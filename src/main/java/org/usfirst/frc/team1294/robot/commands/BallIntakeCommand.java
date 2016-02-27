package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public class BallIntakeCommand extends Command {
  public BallIntakeCommand() {
    requires(Robot.ballHandleSubsystem);
  }

  @Override
  protected void initialize() {

  }

  @Override
  protected void execute() {
    Robot.ballHandleSubsystem.setIntake(Robot.oi.getMechStickOne().getRawAxis(2) - Robot.oi.getMechStickOne().getRawAxis(3));
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {

  }

  @Override
  protected void interrupted() {

  }
}
