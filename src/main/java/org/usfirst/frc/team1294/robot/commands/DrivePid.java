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
		super(String.format("DrivePid(%f, %f, %f)", heading, speed, distance), 0.05,0,0.01);
		
		requires(Robot.driveTrain);
		this.driveTrain = Robot.driveTrain;
		this.heading = heading;
		this.speed = speed;
		this.distance = distance;
		
		// since this is a closed loop command, and may be running without operator intervention, set a timeout
		this.setTimeout(15);
		
		
		
		LiveWindow.addActuator("DriveSystem", "DriveHeadingPid", this.getPIDController());
	}

	@Override
	protected void initialize() {
		// if heading was not provided, use current heading
		if (heading < 0) {
			this.setSetpoint(driveTrain.getNormalizedAngle());
			System.out.println("setpoint to current heading " + driveTrain.getNormalizedAngle());
		} else {
			this.setSetpoint(heading);
		}
		
		this.getPIDController().setInputRange(0, 360);
		this.getPIDController().setOutputRange(-1, 1);
		this.getPIDController().setContinuous();
		
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
		System.out.println("output " + output);
		this.driveTrain.arcadeDrive(speed, output);
	}

	@Override
	protected void execute() {
		
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
			double avgDistance = (
					Math.abs(driveTrain.getLeftPosition() - leftEncoderStart) + 
					Math.abs(driveTrain.getRightPosition() - rightEncoderStart)) / 2;
			
			System.out.println(avgDistance + " " + distance + " " + speed);
			return avgDistance >= distance;
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
