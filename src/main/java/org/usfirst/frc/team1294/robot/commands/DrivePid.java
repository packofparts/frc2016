package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

public class DrivePid extends Command {

	private static final double MAX_MOTOR_SPEED = 0.6;
	
	private static final double HEADING_PID_TOLERANCE = 2;
//	private static final double HEADING_PID_P = 0.15;
//	private static final double HEADING_PID_I = 0.05;
//	private static final double HEADING_PID_D = 0.07;
	
	private static final double HEADING_PID_P = 0.08;
	private static final double HEADING_PID_I = 0.01;
	private static final double HEADING_PID_D = 0.1;
	
	private static final double DISTANCE_PID_TOLERANCE = 1;
	private static final double DISTANCE_PID_P = .5;
	private static final double DISTANCE_PID_I = 1;
	private static final double DISTANCE_PID_D = 10;
	
	protected double heading;
	protected boolean driveCurrentHeading = false;
	protected double distance;
	protected double position;
	
	protected PIDController distanceController;
	protected PIDController headingController;
	protected double commandedSpeed = 0;
	protected double commandedTurn = 0;
	
	public DrivePid(double distance) {
		this(0, distance);
		driveCurrentHeading = true;
	}
	
	public DrivePid(double heading, double distance) {
		requires(Robot.driveBase);
		
		this.heading = heading;
		this.distance = distance;
		
		// since this is a closed loop command, and may be running without operator intervention, set a timeout
		this.setTimeout(15);
		
		distanceController = new PIDController(DISTANCE_PID_P, DISTANCE_PID_I, DISTANCE_PID_D, distanceSource, distanceOutput);
		distanceController.setOutputRange(-MAX_MOTOR_SPEED, MAX_MOTOR_SPEED);
		distanceController.setPercentTolerance(DISTANCE_PID_TOLERANCE);
		
		headingController = new PIDController(HEADING_PID_P, HEADING_PID_I, HEADING_PID_D, headingSource, headingOutput);
		headingController.setInputRange(0, 360);
		headingController.setContinuous();
		headingController.setOutputRange(-MAX_MOTOR_SPEED, MAX_MOTOR_SPEED);
		headingController.setAbsoluteTolerance(HEADING_PID_TOLERANCE);
	}
	
	@Override
	protected void initialize() {
		if (driveCurrentHeading) {
			heading = Robot.driveBase.getNormalizedAngle();
		}
		this.headingController.setSetpoint(heading);
		this.headingController.enable();
		
		this.position = Robot.driveBase.getAveragePosition() + distance;
		this.distanceController.setSetpoint(this.position);
		this.distanceController.enable();
		
		Robot.driveBase.setTalonsToClosedLoopSpeed();
	}

	@Override
	protected void execute() {
//		System.out.println("disiredPosition: " + position + " currentPosition:" 
//			+ Robot.driveBase.getAveragePosition() 
//			+ " commandedSpeed:" + commandedSpeed 
//			+ " commandedTurn:" + commandedTurn 
//			+ " distanceControllerError:" + distanceController.getError()
//			+ " headingControllerError:" + headingController.getError());
		System.out.println(" distanceControllerError:" + distanceController.getError() + " distance" + Robot.driveBase.getAveragePosition());
		Robot.driveBase.arcadeDrive(commandedSpeed, commandedTurn);
	}

	@Override
	protected boolean isFinished() {
		return (isTimedOut() || (distanceController.onTarget() && headingController.onTarget()));
	}

	@Override
	protected void end() {
		this.distanceController.disable();
		this.headingController.disable();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
	private PIDSource distanceSource = new PIDSource() {
		@Override public void setPIDSourceType(PIDSourceType pidSource) {}
		@Override public PIDSourceType getPIDSourceType() { return PIDSourceType.kDisplacement; }
		
		@Override
		public double pidGet() {
			return Robot.driveBase.getAveragePosition();
		}		
	};
	
	private PIDOutput distanceOutput = new PIDOutput() {
		@Override
		public void pidWrite(double output) {
			commandedSpeed = output;
		}
	};
	
	private PIDSource headingSource = new PIDSource() {
		@Override public void setPIDSourceType(PIDSourceType pidSource) {}
		@Override public PIDSourceType getPIDSourceType() { return PIDSourceType.kDisplacement; }
		
		@Override
		public double pidGet() {
			return Robot.driveBase.getNormalizedAngle();
		}
	};
	
	private PIDOutput headingOutput = new PIDOutput() {
		@Override
		public void pidWrite(double output) {
			commandedTurn = output;
		}
	};
}
