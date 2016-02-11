package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {
	private final long waitTime;
	private long start;
	
	public Wait(long waitTime) {
		this.waitTime = waitTime;
	}
	
	@Override
	protected void initialize() {
		start = System.currentTimeMillis();
	}

	@Override
	protected void execute() {	
	}

	@Override
	protected boolean isFinished() {
		return System.currentTimeMillis() - start >= waitTime;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
