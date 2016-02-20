package org.usfirst.frc.team1294.robot;

import org.usfirst.frc.team1294.robot.commands.ArcadeDriveCommand;
import org.usfirst.frc.team1294.robot.commands.AutonomousEasyDefense;
import org.usfirst.frc.team1294.robot.commands.AutonomousReachDefense;
import org.usfirst.frc.team1294.robot.commands.DefensePosition;
import org.usfirst.frc.team1294.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.BallHandlingSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.DriveBase;
import org.usfirst.frc.team1294.robot.subsystems.Vision;
import org.usfirst.frc.team1294.robot.utilities.VersionInformation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
  private static final String WHICH_ROBOT_FILE_NAME = "robot.txt";
  public static DriveBase driveBase;
  public static CameraSubsystem cameraSubsystem;
  public static OI oi;
  public static Vision visionSubsystem;
  public static ArmSubsystem armSubsystem = new ArmSubsystem();
  public static BallHandlingSubsystem ballHandleSubsystem = new BallHandlingSubsystem();
  private static Command autoCommand;
  private static WhichRobot whichRobot = null;
  private SendableChooser autoChooser;

  /**
   * Returns which robot the code is currently running on. This is determined by a file on the
   * roboRIO that contains either a "1" or a "2". This can be used to set constants or run code
   * that works on one robot or the other. If the file can't be found, it defaults to robot #1.
   *
   * <p>This value can be used by comparing it to a value in the enum {@link WhichRobot}.</p>
   *
   * @return the robot that the code is currently running on.
   */
  public static WhichRobot getWhichRobot() {
    if (whichRobot == null) {
      Scanner scanner = null;

      try {
        scanner = new Scanner(new BufferedReader(new FileReader("robot.txt")));
        String in = scanner.nextLine();
        whichRobot = in.equals("2") ? WhichRobot.ROBOT_2 : WhichRobot.ROBOT_1;
      } catch (FileNotFoundException | NumberFormatException e) {
        whichRobot = WhichRobot.ROBOT_1;
      } finally {
        if (scanner != null) scanner.close();
      }
    }

    return whichRobot;
  }

  /**
   * This method is called when the robot is first started up. This method is run before it is
   * marked as ready in FMS. Use this to initialize things like gyros and encoders.
   */
  @Override
  public void robotInit() {

    visionSubsystem = new Vision();
    driveBase = new DriveBase();
    cameraSubsystem = new CameraSubsystem();
    oi = new OI();

    VersionInformation vi = new VersionInformation();
    SmartDashboard.putString("Version", vi.getVersion());
    SmartDashboard.putString("Git-Author", vi.getAuthor());

    SmartDashboard.putData(Scheduler.getInstance());

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
  }

  /**
   * Called when the robot first enters test mode.
   */
  @Override
  public void testInit() {
  }

  // TODO: Refactor into its own utility class?

  /**
   * Called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }

  public enum WhichRobot {ROBOT_1, ROBOT_2}
}
