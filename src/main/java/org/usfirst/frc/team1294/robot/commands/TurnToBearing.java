package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

public class TurnToBearing extends DrivePid {
	protected double bearing;
	
	public TurnToBearing(double bearing) {
		super(0);
		this.bearing = bearing;
	}

	@Override
	protected void initialize() {
		heading = (Robot.driveBase.getNormalizedAngle() + bearing) % 360;
		if (heading < 0) heading += 360;
		super.initialize();
	}
	
	
}
