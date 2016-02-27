package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Austin Jenchi (timtim17)
 */
public class ScoreLowGoalAutonomous extends CommandGroup {
  protected static final double SPEED = -0.5;

  public ScoreLowGoalAutonomous(DefensePosition position) {
//    addSequential(new AutonomousEasyDefense(position));
    addSequential(new DriveStraightDistance(SPEED, position.distanceToWall));
    addSequential(new TurnToBearing(210));
    addSequential(new DriveStraightDistance(SPEED, position.distanceAfterTurn));
    addSequential(new TimedEjectBall(30));
  }
}
