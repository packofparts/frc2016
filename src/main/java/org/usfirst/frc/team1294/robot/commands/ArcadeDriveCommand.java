package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.subsystems.CameraSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public class ArcadeDriveCommand extends Command {
  public ArcadeDriveCommand() {
    requires(Robot.driveBase);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    double forwards = Robot.oi.getStickLeft().getY(); //expo(Robot.oi.getStickLeft().getY(), 0);//1.25);
    double turn = Robot.oi.getStickLeft().getX(); //expo(Robot.oi.getStickLeft().getX(), 0); //1.75);

    if (Robot.CAMERA_SUBSYSTEM.getCurrentCamera() == CameraSubsystem.Camera.BACK) {
      forwards *= -1;
    }

    Robot.driveBase.arcadeDrive(forwards, turn);
  }
  
  protected double expo(double input, double expoAmount) {
	  return (Math.pow(input, 3) * (expoAmount-1) + input)/expoAmount;
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {

  }

  @Override
  protected void interrupted() {

  }
}
