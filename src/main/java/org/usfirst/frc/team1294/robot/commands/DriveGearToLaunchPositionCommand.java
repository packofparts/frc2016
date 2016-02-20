package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

/**
 * @author Austin Jenchi (timtim17)
 */
public class DriveGearToLaunchPositionCommand extends DriveGearCommand {
  private static final double SPEED = 1;

  public DriveGearToLaunchPositionCommand() {
    super(SPEED);
  }

  @Override
  protected boolean isFinished() {
    return Robot.ballHandleSubsystem.isGearLimitSwitchClosed();
  }
}
