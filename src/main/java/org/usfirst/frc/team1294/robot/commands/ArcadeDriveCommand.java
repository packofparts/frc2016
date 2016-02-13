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
    Robot.driveBase.arcadeDrive(expo(Robot.oi.getStickLeft().getY(), 1.25), expo(Robot.oi.getStickLeft().getX(), 1.75));
  }
  
  protected double expo(double input, double expoAmount) {
	  return (Math.pow(input, 3) * (expoAmount-1) + input)/expoAmount;
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
