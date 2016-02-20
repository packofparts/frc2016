package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

/**
 * @author Austin Jenchi (timtim17)
 */
public class DriveGearToRestPositionCommand extends DriveGearCommand {
  private static final double SPEED = 0.1;

  public DriveGearToRestPositionCommand() {
    super(SPEED);
  }

  @Override
  protected boolean isFinished() {
    return !Robot.ballHandleSubsystem.isCatapultLimitSwitchClosed();
  }
}
