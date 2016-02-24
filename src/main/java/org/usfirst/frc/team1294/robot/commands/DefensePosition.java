package org.usfirst.frc.team1294.robot.commands;

public enum DefensePosition {
  ONE(0, 0, 0, 0), // TODO calculate bearing and both distances
  TWO(0, 0, 0, 0), // TODO calculate bearing and both distances
  THREE(0, 0, 0, 0), // TODO calculate bearing and both distances
  FOUR(0, 0, 0, 0), // TODO calculate bearing and both distances
  FIVE(0, 0, 0, 0); // TODO calculate bearing and both distances

  final double distanceBeforeTurn;
  final double bearingToCastle;
  final double distanceAfterTurn;
  final double distanceToWall;

  DefensePosition(double distanceBeforeTurn, double bearingToCastle, double distanceAfterTurn, double distanceToWall) {
    this.distanceBeforeTurn = distanceBeforeTurn;
    this.bearingToCastle = bearingToCastle;
    this.distanceAfterTurn = distanceAfterTurn;
    this.distanceToWall = distanceToWall;
  }

}
