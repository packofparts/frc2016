package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.subsystems.BallHandlingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public class SetIntakeDirection extends Command {
  private BallHandlingSubsystem.IntakeDirection direction;

  public SetIntakeDirection(BallHandlingSubsystem.IntakeDirection direction) {
    this.direction = direction;

    requires(Robot.ballHandleSubsystem);
  }

  @Override
  protected void initialize() {
    setTimeout(5); // TODO: replace with check if ball still exists
    Robot.ballHandleSubsystem.setIntakeDirection(direction);
  }

  @Override
  protected void execute() {
    // nothing to do
    // no watchdog, just set it and forget it
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut(); // TODO: replace with check if ball still exists
  }

  @Override
  protected void end() {
    Robot.ballHandleSubsystem.setIntakeDirection(BallHandlingSubsystem.IntakeDirection.STOP);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
