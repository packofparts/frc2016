package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.subsystems.CameraSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A simple command that sets the camera in the subsystem and ends immediately.
 *
 * @author Austin Jenchi (timtim17)
 * @see org.usfirst.frc.team1294.robot.subsystems.CameraSubsystem
 */
public class SetCameraCommand extends Command {
  private CameraSubsystem.Camera camera;

  public SetCameraCommand(CameraSubsystem.Camera camera) {
    super("Sets camera to " + camera.toString());
    requires(Robot.CAMERA_SUBSYSTEM);
    this.camera = camera;
  }

  @Override
  protected void initialize() {
    Robot.CAMERA_SUBSYSTEM.startStream(camera);
  }

  @Override
  protected void execute() {
    // nothing to do
  }

  @Override
  protected boolean isFinished() {
    return true; // we're done after initialize()
  }

  @Override
  protected void end() {
    // nothing to do
  }

  @Override
  protected void interrupted() {
    // nothing to do
  }
}
