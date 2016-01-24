package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveHeadingPid extends PIDCommand {

	private DriveSystem driveTrain;
	private double speed;
	
	public DriveHeadingPid(double heading, double speed) {
		super(0.5,0,0);
		requires(Robot.driveTrain);
		this.driveTrain = Robot.driveTrain;
		this.speed = speed;
		this.setTimeout(10);
		this.getPIDController().setInputRange(0, 359);
		this.getPIDController().setOutputRange(-1, 1);
		this.getPIDController().setContinuous();
		
		this.setSetpoint(heading);
		LiveWindow.addActuator("DriveSystem", "DriveHeadingPid", this.getPIDController());
	}

	@Override
	protected double returnPIDInput() {
		return this.driveTrain.getNormalizedAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		double leftSpeed = this.speed;
		double rightSpeed = this.speed;
		
		if (output < 0) {
			// CCW, but since our motors seem to be reversed, correcting here for now
			leftSpeed += output;
			rightSpeed -= output;
		} else if (output > 0) {
			// CW
			leftSpeed -= output;
			rightSpeed += output;
		}
		
		// the output of the pid (value of output) is constrained to -1 to 1, but since we are adding/subtracting from
		// speed, we need to make sure the output stays within -1 to 1.
		if (leftSpeed > 1)
			leftSpeed = 1;
		if (leftSpeed < -1)
			leftSpeed = -1;
		if (rightSpeed > 1)
			rightSpeed = 1;
		if (rightSpeed < -1)
			rightSpeed = -1;
		
		this.driveTrain.tankDrive(leftSpeed, rightSpeed);
	}

	@Override
	protected void initialize() {
		SmartDashboard.putData(this);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		this.driveTrain.tankDrive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
