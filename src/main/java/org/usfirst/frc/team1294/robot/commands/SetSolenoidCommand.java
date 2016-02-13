package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public class SetSolenoidCommand extends Command {
  private boolean on;

  public SetSolenoidCommand(boolean on) {
    this.on = on;

    requires(Robot.ballHandleSubsystem);
  }

  @Override
  protected void initialize() {
    Robot.ballHandleSubsystem.intakeSolenoid(on);
  }

  @Override
  protected void execute() {

  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {

  }

  @Override
  protected void interrupted() {

  }
}
