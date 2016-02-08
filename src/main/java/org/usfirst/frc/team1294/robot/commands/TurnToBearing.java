package org.usfirst.frc.team1294.robot.commands;

public class TurnToBearing extends DrivePid {
	public TurnToBearing(double bearing) {
		super(0);
		heading = driveBase.getNormalizedAngle() + bearing;
	}
}
