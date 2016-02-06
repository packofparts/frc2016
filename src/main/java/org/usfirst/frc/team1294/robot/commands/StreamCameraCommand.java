package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public class StreamCameraCommand extends Command {
  private static final int FPS = 30;
  private Thread captureThread;

  public StreamCameraCommand() {
    requires(Robot.CAMERA_SUBSYSTEM);
  }

  @Override
  protected void initialize() {
    captureThread = new Thread(() -> {
      while (true) {
        Robot.CAMERA_SUBSYSTEM.stream();
        System.out.println(1 / (double) FPS);
        Timer.delay(1 / (double) FPS);
      }
    });
    captureThread.setName("Camera Capture Thread");
    captureThread.start();
  }

  @Override
  protected void execute() {

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    captureThread.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
