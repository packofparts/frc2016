package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public class StreamCameraCommand extends Command {
  private static final int FPS = 30;

  public StreamCameraCommand() {
    requires(Robot.CAMERA_SUBSYSTEM);
  }

  @Override
  protected void initialize() {

  }

  @Override
  protected void execute() {
    Robot.CAMERA_SUBSYSTEM.stream();
    Timer.delay(1 / (double) FPS * 1000);
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
