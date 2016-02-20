package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public abstract class DriveGearCommand extends Command {
  private double speed;

  public DriveGearCommand(double speed) {
    requires(Robot.ballHandleSubsystem);
    this.speed = speed;
  }

  @Override
  protected void initialize() {
    Robot.ballHandleSubsystem.setGear(speed);
  }

  @Override
  protected void execute() {
    // nothing to do
  }

  @Override
  protected void end() {
    Robot.ballHandleSubsystem.stopGear();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
