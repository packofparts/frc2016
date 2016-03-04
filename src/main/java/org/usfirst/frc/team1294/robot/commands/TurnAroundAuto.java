package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Austin Jenchi (timtim17)
 */
public class TurnAroundAuto extends CommandGroup {
  public TurnAroundAuto() {
    addSequential(new DriveStraightDistance(-0.5, 3.5));
    addSequential(new TurnToHeading(235));
//    addSequential(new DriveStraightDistance(0.5, 1));
  }
}
