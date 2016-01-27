package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivePid extends PIDCommand {

	private DriveBase driveTrain;
	private double heading;
	private double speed;
	private double distance;
	private double leftEncoderStart;
	private double rightEncoderStart;
	private double leftSpeed;
	private double rightSpeed;
		
	public DrivePid(double heading, double speed, double distance) {
		// TODO: tune this pid
		super(0.5,0,0);
		
		requires(Robot.driveTrain);
		this.driveTrain = Robot.driveTrain;
		this.heading = heading;
		this.speed = speed;
		this.distance = distance;
		
		// since this is a closed loop command, and may be running without operator intervention, set a timeout
		this.setTimeout(15);
		
		this.getPIDController().setInputRange(0, 359);
		this.getPIDController().setOutputRange(-1, 1);
		this.getPIDController().setContinuous();
		
		LiveWindow.addActuator("DriveSystem", "DriveHeadingPid", this.getPIDController());
	}

	@Override
	protected void initialize() {
		// if heading was not provided, use current heading
		if (heading < 0) {
			heading = driveTrain.getNormalizedAngle();
		}
		this.setSetpoint(heading);
		
		this.leftEncoderStart = this.driveTrain.getLeftPosition();
		this.rightEncoderStart = this.driveTrain.getRightPosition();
	
		SmartDashboard.putData(this);
	}
	
	@Override
	protected double returnPIDInput() {
		return this.driveTrain.getNormalizedAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		leftSpeed = this.speed;
		rightSpeed = this.speed;
		
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
	}

	@Override
	protected void execute() {
		this.driveTrain.tankDrive(leftSpeed, rightSpeed);
	}

	@Override
	protected boolean isFinished() {
		if (isTimedOut()) {
			return true;
		}
		
		if (distance == 0) {
			// distance set to 0, which means turn to heading, turn until heading is close enough
			return Math.abs(driveTrain.getNormalizedAngle() - this.heading) < 1;
		} else {
			// average the distance reported by both encoders
			double avgDistance = ((driveTrain.getLeftPosition() - leftEncoderStart) + 
					(driveTrain.getRightPosition() - rightEncoderStart)) / 2;
			return avgDistance / RobotMap.distanceScaler <= distance;
		}
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
