package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command{
	private double startDistance;
	private double desiredDistance;
	private double desiredSpeed;
	public DriveDistance(double distance, double speed) {
		requires (Robot.driveTrain);
		this.desiredDistance = distance;
		this.desiredSpeed = speed;
	}
	protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.setToEncoders();
    	Robot.driveTrain.arcadeDrive(-this.desiredSpeed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // Runs until interrupted
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }

}
