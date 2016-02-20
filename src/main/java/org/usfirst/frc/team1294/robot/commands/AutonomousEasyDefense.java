package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous command that drives forward a calculated distance, turns to roughly face the castle,
 * uses vision system to fine tune the aim, and shoots. Easy defenses are: Low Bar, Moat, Ramparts,
 * Rock Wall, Rough Terrain
 */
public class AutonomousEasyDefense extends AutonomousReachDefense {
  protected static final double DISTANCE_TO_DEFEAT_DEFENSE = 1.0; // TODO, how far to drive to defeat the defense

  public AutonomousEasyDefense(DefensePosition position) {
    super();

    addSequential(new DriveStraightDistance(SPEED, DISTANCE_TO_DEFEAT_DEFENSE));

    if (position.distanceBeforeTurn > 0) {
      addSequential(new DriveStraightDistance(SPEED, position.distanceBeforeTurn));
    }
    if (position.bearingToCastle != 0) {
      addSequential(new TurnToBearing(position.bearingToCastle));
    }
    if (position.distanceAfterTurn > 0) {
      addSequential(new DriveStraightDistance(SPEED, position.distanceAfterTurn));
    }

    addSequential(new WaitCommand(1));
    addSequential(new TurnTowardsVisionTarget());
    addSequential(new WaitCommand(1));
    addSequential(new TurnTowardsVisionTarget());
    // TODO shoot
  }
}
