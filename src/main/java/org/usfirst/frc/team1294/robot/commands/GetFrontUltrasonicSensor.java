package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GetFrontUltrasonicSensor extends Command {

	public GetFrontUltrasonicSensor() {
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
		System.out.println(Robot.driveBase.getUltrasonicDistanceFront());
		SmartDashboard.putNumber("ultra", Robot.driveBase.getUltrasonicDistanceFront());
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
