package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WallFollowing extends Command{

	public WallFollowing() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if(Robot.driveBase.getUltrasonicDistanceLeft() > 40){
			Robot.driveBase.tankDrive(.3, .5);
		}
		else if(Robot.driveBase.getUltrasonicDistanceLeft() < 40){
			Robot.driveBase.tankDrive(.5,.3);
		}
		else{
			Robot.driveBase.tankDrive(.5, .5);
		}
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
