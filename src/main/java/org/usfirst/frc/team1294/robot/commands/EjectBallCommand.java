package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.subsystems.BallHandlingSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Austin Jenchi (timtim17)
 */
public class EjectBallCommand extends CommandGroup {
  public EjectBallCommand() {
    addParallel(new SetSolenoidCommand(true));
    addSequential(new SetIntakeDirection(BallHandlingSubsystem.IntakeDirection.OUT));
    addSequential(new SetSolenoidCommand(false));
  }
}
