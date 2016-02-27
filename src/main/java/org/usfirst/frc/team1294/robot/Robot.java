package org.usfirst.frc.team1294.robot;

import org.usfirst.frc.team1294.robot.commands.ArcadeDriveCommand;
import org.usfirst.frc.team1294.robot.commands.AutonomousEasyDefense;
import org.usfirst.frc.team1294.robot.commands.AutonomousReachDefense;
import org.usfirst.frc.team1294.robot.commands.DefensePosition;
import org.usfirst.frc.team1294.robot.commands.SwitchToClosedLoopMode;
import org.usfirst.frc.team1294.robot.commands.SwitchToOpenLoopMode;
import org.usfirst.frc.team1294.robot.subsystems.BallHandlingSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.DriveBase;
import org.usfirst.frc.team1294.robot.subsystems.Vision;
import org.usfirst.frc.team1294.robot.utilities.VersionInformation;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The main class for the robot. The roboRIO automatically runs this program at the specified
 * times.
 */
public class Robot extends IterativeRobot {
  public static DriveBase driveBase;
  public static CameraSubsystem cameraSubsystem;
  public static OI oi;
  public static Vision visionSubsystem;
  //public static ArmSubsystem armSubsystem = new ArmSubsystem();
  public static BallHandlingSubsystem ballHandleSubsystem;
  private static Command autoCommand;
  private SendableChooser autoChooser;

  /**
   * This method is called when the robot is first started up. This method is run before it is
   * marked as ready in FMS. Use this to initialize things like gyros and encoders.
   */
  @Override
  public void robotInit() {
	ballHandleSubsystem = new BallHandlingSubsystem();  
    visionSubsystem = new Vision();
    driveBase = new DriveBase();
    cameraSubsystem = new CameraSubsystem();
    oi = new OI();

    VersionInformation vi = new VersionInformation();
    SmartDashboard.putString("Version", vi.getVersion());
    SmartDashboard.putString("Git-Author", vi.getAuthor());

      SmartDashboard.putData(new SwitchToClosedLoopMode());
      SmartDashboard.putData(new SwitchToOpenLoopMode());

//        LiveWindow.addSensor(Vision.class.getSimpleName(), Vision.class.getSimpleName(), vision);
        SmartDashboard.putData(Scheduler.getInstance());
        
        // turn to heading in place
//        SmartDashboard.putData(new DrivePid(0));
//        SmartDashboard.putData(new DrivePid(90));
//        SmartDashboard.putData(new DrivePid(180));
//        SmartDashboard.putData(new DrivePid(270));
//
//        // drive current heading for one meter
//        SmartDashboard.putData(new DrivePid(-0.5, 1));
//        SmartDashboard.putData(new DrivePid(0.5, 1));

    SmartDashboard.putData(new ArcadeDriveCommand());

    SmartDashboard.putData(Scheduler.getInstance());

    // SendableChooser for Autonomous Commands
    autoChooser = new SendableChooser();
    autoChooser.addDefault("Reach Defense", new AutonomousReachDefense());
    autoChooser.addObject("Position 1 Low Bar", new AutonomousEasyDefense(DefensePosition.ONE));
    autoChooser.addObject("Position 2 Easy", new AutonomousEasyDefense(DefensePosition.TWO));
    autoChooser.addObject("Position 3 Easy", new AutonomousEasyDefense(DefensePosition.THREE));
    autoChooser.addObject("Position 4 Easy", new AutonomousEasyDefense(DefensePosition.FOUR));
    autoChooser.addObject("Position 5 Easy", new AutonomousEasyDefense(DefensePosition.FIVE));
    // TODO if we have the hardware, add choosers for positions 2 - 5 for Sally Port, DrawBridge, Cheval de Frise, Portcullis
    SmartDashboard.putData("Auto chooser", autoChooser);
  }

  /**
   * Called when the robot first enters disabled (i.e. the robot has just left auto, teleop, or
   * robotInit).
   */
  @Override
  public void disabledInit() {
  }

  /**
   * Called periodically while the robot is disabled.
   */
  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * Called when the robot first enters auto.
   */
  @Override
  public void autonomousInit() {
    autoCommand = (Command) autoChooser.getSelected();
    if (autoCommand != null) autoCommand.start();
  }

  /**
   * Called periodically during auto.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * Called when the robot first enters teleop.
   */
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autoCommand != null) autoCommand.cancel();
  }

    /**
     * Called periodically during teleop.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Gyro Angle", driveBase.getNormalizedAngle());
        SmartDashboard.putNumber("Left Enc", driveBase.getLeftSpeed());
        SmartDashboard.putNumber("Right Enc", driveBase.getRightSpeed());
      SmartDashboard.putBoolean("Is Closed Loop", driveBase.isClosedLoopMode());
    }

  /**
   * Called when the robot first enters test mode.
   */
  @Override
  public void testInit() {
  }

  /**
   * Called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }

}
