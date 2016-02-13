package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public class CatapultLetGoCommand extends Command {
  public CatapultLetGoCommand() {
    requires(Robot.ballHandleSubsystem);
  }

  @Override
  protected void initialize() {
    Robot.ballHandleSubsystem.setCatapultBrakeMode(true);
    setTimeout(2); // TODO: Find correct timeout to let boulder shoot
  }

  @Override
  protected void execute() {
    // nothing to do
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    Robot.ballHandleSubsystem.setCatapultBrakeMode(false);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
