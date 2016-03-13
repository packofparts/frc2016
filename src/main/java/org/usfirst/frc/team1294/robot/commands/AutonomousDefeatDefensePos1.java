package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Austin Jenchi (timtim17)
 */
public class AutonomousDefeatDefensePos1 extends CommandGroup {
  public AutonomousDefeatDefensePos1() {
    addSequential(new DriveArmForwardCommand());
    addSequential(new AutonomousDefeatDefense());
  }
}
