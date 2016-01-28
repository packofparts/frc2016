package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class TurnCommand extends Command{
private double deltaDegrees;
private double startAngle;
private double desieredAngle;
	public TurnCommand(double deltaDegrees) {
		// TODO Auto-generated constructor stub\
		this.deltaDegrees = deltaDegrees;
		requires (Robot.driveBase);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		startAngle = Robot.driveBase.getGyro().getAngle();
		desieredAngle = startAngle + deltaDegrees;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (Robot.driveBase.getGyro().getAngle() < desieredAngle)
			Robot.driveBase.tankDrive(-0.5, 0.5);
		else Robot.driveBase.tankDrive(0.5, -0.5);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Math.abs(desieredAngle - Robot.driveBase.getGyro().getAngle()) < 5;
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
