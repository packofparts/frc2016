package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

@Deprecated
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
		startAngle = Robot.driveBase.getRawAngle();
		desieredAngle = startAngle + deltaDegrees;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (Robot.driveBase.getRawAngle() < desieredAngle)
			Robot.driveBase.tankDrive(-0.5, 0.5);
		else Robot.driveBase.tankDrive(0.5, -0.5);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Math.abs(desieredAngle - Robot.driveBase.getRawAngle()) < 5;
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
