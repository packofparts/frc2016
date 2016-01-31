package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Austin Jenchi (timtim17)
 */
public class TwoPIDControllerCommand extends Command {
  private static final double PID_TOLERANCE = 1;

  private static final double TURNPID_P = 0.15;
  private static final double TURNPID_I = 0.02;
  private static final double TURNPID_D = 0.09;

  // TODO: Tune PID
  private static final double MOVEPID_P = 0.15;
  private static final double MOVEPID_I = 0.00;
  private static final double MOVEPID_D = 0.09;

  private final double heading;
  private final double speed;
  private final double distance;

  private PIDController turnController;
  private PIDController moveController;
  private TurnPIDOutput turnOutput;
  private MovePIDOutput moveOutput;

  public TwoPIDControllerCommand(double heading) {
    this(String.format("Turn to a heading of %f", heading), heading, 0, 0, 15);
  }

  public TwoPIDControllerCommand(double speed, double distance) {
    this(String.format("Drive the current heading at a speed of %f for a distance of %f.", speed, distance), -1, speed, distance, 15);
  }

  public TwoPIDControllerCommand(double heading, double speed, double distance) {
    this(String.format("Drive a heading of %f at a speed of %f for a distance of %f.", heading, speed, distance), heading, speed, distance, 15);
  }

  public TwoPIDControllerCommand(double heading, double speed, double distance, double timeout) {
    this(String.format("Drive a heading of %f at a speed of %f for a distance of %f with a timeout of %f.", heading, speed, distance, timeout), heading, speed, distance, timeout);
  }

  private TwoPIDControllerCommand(String name, double heading, double speed, double distance, double timeout) {
    requires(Robot.driveBase);

    this.heading = heading;
    this.speed = speed;
    this.distance = distance;

    turnOutput = new TurnPIDOutput();
    moveOutput = new MovePIDOutput();
    turnController = new PIDController(TURNPID_P, TURNPID_I, TURNPID_D, new GyroPIDSource(), turnOutput);
    moveController = new PIDController(MOVEPID_P, MOVEPID_I, MOVEPID_D, new AverageEncoderPIDSource(), moveOutput);

    LiveWindow.addActuator("TwoPIDControllerCommand", "turnController", turnController);
    LiveWindow.addActuator("TwoPIDControllerCommand", "moveController", moveController);

    // since this is a closed loop command, and may be running without operator intervention, set a timeout
    setTimeout(timeout);
  }

  @Override
  protected void initialize() {
    // if heading was not provided, use current heading
    if (heading < 0) {
      turnController.setSetpoint(Robot.driveBase.getNormalizedAngle());
      System.out.println("setpoint to current heading " + Robot.driveBase.getNormalizedAngle());
    } else {
      turnController.setSetpoint(heading);
    }
    turnController.setInputRange(0, 360);
    turnController.setOutputRange(-0.4, 0.4);
    turnController.setContinuous();
    turnController.setAbsoluteTolerance(PID_TOLERANCE);
    turnController.enable();

    moveController.setSetpoint(distance);
    moveController.setOutputRange(-speed, speed);
    moveController.setAbsoluteTolerance(PID_TOLERANCE);
    moveController.enable();

    Robot.driveBase.setTalonsToClosedLoopSpeed();

    SmartDashboard.putData(this);
  }

  @Override
  protected void execute() {
    Robot.driveBase.arcadeDrive(moveOutput.getOutput(), turnOutput.getOutput());
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut() || (turnController.onTarget() && moveController.onTarget());

  }

  @Override
  protected void end() {
    //this.driveBase.setTalonsToOpenLoop();
    //this.driveBase.arcadeDrive(0, 0);
  }

  @Override
  protected void interrupted() {
    end();
  }

  private static class GyroPIDSource implements PIDSource {
    @Override
    public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {
      // does nothing
    }

    @Override
    public double pidGet() {
      return Robot.driveBase.getNormalizedAngle();
    }
  }

  private static class AverageEncoderPIDSource implements PIDSource {
    @Override
    public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {
      // does nothing
    }

    @Override
    public double pidGet() {
      return (Robot.driveBase.getLeftPosition() + Robot.driveBase.getRightPosition()) / 2;
    }
  }

  // A couple of semi-workaround classes to implement getting the output from the PID
  private static class TurnPIDOutput implements PIDOutput {
    private double output;

    @Override
    public void pidWrite(double output) {
      this.output = output;
    }

    public double getOutput() {
      return output;
    }
  }

  private static class MovePIDOutput implements PIDOutput {
    private double output;

    @Override
    public void pidWrite(double output) {
      this.output = output;
    }

    public double getOutput() {
      return output;
    }
  }
}
