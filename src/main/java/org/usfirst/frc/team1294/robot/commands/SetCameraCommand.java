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
  private static final double DEADBAND = 100;

  private CameraSubsystem.Camera camera;

  public SetCameraCommand(CameraSubsystem.Camera camera) {
    super("Sets camera to " + camera.toString());
    requires(Robot.CAMERA_SUBSYSTEM);
    this.camera = camera;
  }

  @Override
  protected void initialize() {
    double speed = (Robot.driveBase.getLeftSpeed() + Robot.driveBase.getRightSpeed()) / 2.0;
    if (speed < DEADBAND)
      Robot.CAMERA_SUBSYSTEM.startStream(camera); // plz no kill robot due to voltage spike
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
