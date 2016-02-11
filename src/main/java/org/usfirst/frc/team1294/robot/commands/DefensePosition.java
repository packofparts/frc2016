package org.usfirst.frc.team1294.robot.commands;

public enum DefensePosition {
	ONE(0), // TODO calculate bearing
	TWO(0), // TODO calculate bearing
	THREE(0), // TODO calculate bearing
	FOUR(0), // TODO calculate bearing
	FIVE(0); // TODO calculate bearing
	
	final double bearingToCastle;
	
	DefensePosition(double bearing) {
		this.bearingToCastle = bearing;
	}
	
}
