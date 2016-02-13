package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public class ArcadeDriveCommand extends Command {
  public ArcadeDriveCommand() {
    requires(Robot.driveBase);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.driveBase.arcadeDrive(Robot.oi.getStickLeft().getY(), Robot.oi.getStickLeft().getX() * 0.5);
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
