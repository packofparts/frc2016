package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Austin Jenchi (timtim17)
 */
public class LaunchBallCommand extends CommandGroup {
  public LaunchBallCommand() {
    addSequential(new CatapultLetGoCommand());
    addSequential(new ResetCatapultCommand());
  }
}
