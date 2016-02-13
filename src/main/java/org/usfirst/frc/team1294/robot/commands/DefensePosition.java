package org.usfirst.frc.team1294.robot.commands;

public enum DefensePosition {
	ONE(1,30,2), // TODO calculate bearing and both distances
	TWO(1,20,1.5), // TODO calculate bearing and both distances
	THREE(1,10,1), // TODO calculate bearing and both distances
	FOUR(1,0,1), // TODO calculate bearing and both distances
	FIVE(1,-10,1); // TODO calculate bearing and both distances
	
	final double distanceBeforeTurn;
	final double bearingToCastle;
	final double distanceAfterTurn;
	
	DefensePosition(double distanceBeforeTurn, double bearingToCastle, double distanceAfterTurn) {
		this.distanceBeforeTurn = distanceBeforeTurn;
		this.bearingToCastle = bearingToCastle;
		this.distanceAfterTurn = distanceAfterTurn;
	}
	
}
