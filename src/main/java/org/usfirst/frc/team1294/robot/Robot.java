package org.usfirst.frc.team1294.robot;

import org.usfirst.frc.team1294.robot.commands.DrivePid;
import org.usfirst.frc.team1294.robot.commands.ResetGyro;
import org.usfirst.frc.team1294.robot.commands.SquareAutonomousCommand;
import org.usfirst.frc.team1294.robot.subsystems.DriveBase;
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
	public static final DriveBase driveBase = new DriveBase();

    public static OI oi;

    private static Command autoCommand;

    /**
     * This method is called when the robot is first started up.
     * This method is run before it is marked as ready in FMS.
     * Use this to initialize things like gyros and encoders.
     */
    @Override
    public void robotInit() {
        oi = new OI();

        VersionInformation vi = new VersionInformation();
        SmartDashboard.putString("Version", vi.getVersion());
        SmartDashboard.putString("Git-Author", vi.getAuthor());
        SmartDashboard.putData(Scheduler.getInstance());
        
        // turn to heading in place
        SmartDashboard.putData(new DrivePid(0, 0, 0));
        SmartDashboard.putData(new DrivePid(90, 0, 0));
        SmartDashboard.putData(new DrivePid(180, 0, 0));
        SmartDashboard.putData(new DrivePid(270, 0, 0));
        
        // turn to heading while driving one meter
//        SmartDashboard.putData(new DrivePid(0, 0.5, 1));
//        SmartDashboard.putData(new DrivePid(90, 0.5, 1));
//        SmartDashboard.putData(new DrivePid(180, 0.5, 1));
//        SmartDashboard.putData(new DrivePid(270, 0.5, 1));
//        
        // drive current heading for one meter
        SmartDashboard.putData(new DrivePid(-1, -0.75, 1));
        SmartDashboard.putData(new DrivePid(-1, 0.75, 1));
        
        SmartDashboard.putData(new ResetGyro());
        
        //this.autoCommand = new SquareAutonomousCommand();
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
        SmartDashboard.putNumber("Gyro Angle", driveBase.getGyro().getAngle());
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
