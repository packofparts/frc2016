package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

public class DriveCurrentHeadingPid extends DriveHeadingPid {
	public DriveCurrentHeadingPid(double speed) {
		super(Robot.driveTrain.getNormalizedAngle(), speed);
	}
}
