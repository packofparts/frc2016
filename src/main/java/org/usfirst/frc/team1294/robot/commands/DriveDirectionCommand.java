package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.subsystems.DriveBase.Direction;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the robot to drive in the specified direction.
 *
 * @author Austin Jenchi (timtim17)
 */
public class DriveDirectionCommand extends Command {
  private Direction direction;

  /**
   * Sets the direction to the specified direction.
   */
  public DriveDirectionCommand(Direction direction) {
    requires(Robot.driveBase);
    this.direction = direction;
  }

  @Override
  protected void initialize() {
    Robot.driveBase.setDirection(direction);
  }

  @Override
  protected void execute() {

  }

  @Override
  protected boolean isFinished() {
    return true; // ends immediately after it starts - all the real work is done in initialize()
  }

  @Override
  protected void end() {

  }

  @Override
  protected void interrupted() {

  }
}
