package org.usfirst.frc.team1294.robot.commands;

public class TurnToHeadingPid extends DriveHeadingPid {
	public TurnToHeadingPid(double heading) {
		super(heading, 0);
		this.setTimeout(5);
	}
}
