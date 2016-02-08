package org.usfirst.frc.team1294.robot.commands;

public class TurnToBearing extends DrivePid {
	protected double bearing;
	
	public TurnToBearing(double bearing) {
		super(0,0,0);
		this.bearing = bearing;
	}

	@Override
	protected void initialize() {
		heading = driveBase.getNormalizedAngle() + bearing;
		super.initialize();
	}
	
	
}
