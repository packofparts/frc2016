package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TimedEjectBall extends Command{
private double timeout;
	public TimedEjectBall(double time){
		// TODO Auto-generated constructor stub
		timeout = time;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		setTimeout(timeout);
		Robot.ballHandleSubsystem.setIntake(-1);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.ballHandleSubsystem.stopIntake();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.ballHandleSubsystem.stopIntake();
	}

}
