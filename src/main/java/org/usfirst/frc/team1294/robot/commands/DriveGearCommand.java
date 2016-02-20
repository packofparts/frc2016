package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public abstract class DriveGearCommand extends Command {
  public DriveGearCommand() {
    requires(Robot.ballHandleSubsystem);
  }

  @Override
  protected void initialize() {
    Robot.ballHandleSubsystem.setGear(Relay.Value.kForward);
  }

  @Override
  protected void execute() {
    // nothing to do
  }

  @Override
  protected void end() {
    Robot.ballHandleSubsystem.setGear(Relay.Value.kOff);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
