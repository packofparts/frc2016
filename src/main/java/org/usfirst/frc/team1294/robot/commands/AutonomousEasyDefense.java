package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous command that drives forward a calculated distance, turns to roughly face the castle,
 * uses vision system to fine tune the aim, and shoots. Easy defenses are: Low Bar, Moat, Ramparts,
 * Rock Wall, Rough Terrain
 */
public class AutonomousEasyDefense extends CommandGroup {

  protected static final double DISTANCE_TO_REACH_DEFENSE = 3.4; // TODO determine the correct distance
  protected static final double SPEED = -0.5;

  public AutonomousEasyDefense() {
    addSequential(new DriveStraightDistance(SPEED, DISTANCE_TO_REACH_DEFENSE));
  }

}
