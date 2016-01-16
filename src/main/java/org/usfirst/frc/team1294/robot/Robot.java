package org.usfirst.frc.team1294.robot;

import org.usfirst.frc.team1294.robot.subsystems.DriveSystem;
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
	public static final DriveSystem driveTrain = new DriveSystem();

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
