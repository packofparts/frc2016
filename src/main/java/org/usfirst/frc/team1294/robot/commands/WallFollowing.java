package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WallFollowing extends Command{

	public WallFollowing() {
		// TODO Auto-generated constructor stub
		requires (Robot.driveBase);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		double difference = 20 - Robot.driveBase.getUltrasonicDistanceLeft();
		double turnAngle = Math.toDegrees(Math.asin(difference/31));
		Robot.driveBase.arcadeDrive(0.5, turnAngle*-1);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}