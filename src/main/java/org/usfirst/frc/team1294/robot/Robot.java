package org.usfirst.frc.team1294.robot;

import org.usfirst.frc.team1294.robot.commands.ArcadeDriveCommand;
import org.usfirst.frc.team1294.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.DriveBase;
import org.usfirst.frc.team1294.robot.subsystems.Vision;
import org.usfirst.frc.team1294.robot.utilities.VersionInformation;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The main class for the robot. The roboRIO automatically runs this program
 * at the specified times.
 */
public class Robot extends IterativeRobot {
    public static final Vision vision = new Vision();
    public static final DriveBase driveBase = new DriveBase();
    public static final CameraSubsystem cameraSubsystem = new CameraSubsystem();
    public static OI oi;
    private static Command autoCommand;
    public Vision visionSubsystem;

    /**
     * This method is called when the robot is first started up.
     * This method is run before it is marked as ready in FMS.
     * Use this to initialize things like gyros and encoders.
     */
    @Override
    public void robotInit() {
        visionSubsystem = new Vision();

        oi = new OI(visionSubsystem);

        VersionInformation vi = new VersionInformation();
        SmartDashboard.putString("Version", vi.getVersion());
        SmartDashboard.putString("Git-Author", vi.getAuthor());

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

//        SmartDashboard.putData(new ResetGyro());

//        autoCommand = new SquareAutonomousCommand();
//        SmartDashboard.putData(new SinBreakInCommand());
//
//        SmartDashboard.putData(new SetCameraCommand(CameraSubsystem.Camera.FRONT));
//        SmartDashboard.putData(new SetCameraCommand(CameraSubsystem.Camera.BACK));
//
//        SmartDashboard.putData(new SwitchCameraCommand());
//
//        SmartDashboard.putData(new TurnTowardsVisionTarget(visionSubsystem));

//        SmartDashboard.putData(new TurnToBearing(-30));

        SmartDashboard.putData(new ArcadeDriveCommand());
    }

    /**
     * Called when the robot first enters disabled (i.e. the
     * robot has just left auto, teleop, or robotInit).
     */
    @Override
    public void disabledInit() {}

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
    public void testInit() {}

    /**
     * Called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}
