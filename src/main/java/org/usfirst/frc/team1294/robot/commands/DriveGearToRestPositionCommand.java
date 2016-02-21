package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

/**
 * @author Austin Jenchi (timtim17)
 */
public class DriveGearToRestPositionCommand extends DriveGearCommand {
  @Override
  protected boolean isFinished() {
    return !Robot.ballHandleSubsystem.isCatapultLimitSwitchClosed();
  }

  @Override
  public double getSpeed() {
    return 0.1;
  }
}
