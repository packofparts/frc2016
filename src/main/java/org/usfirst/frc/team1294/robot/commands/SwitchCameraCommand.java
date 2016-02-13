package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.subsystems.CameraSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Austin Jenchi (timtim17)
 */
public class SwitchCameraCommand extends Command {
  public SwitchCameraCommand() {
    requires(Robot.CAMERA_SUBSYSTEM);
  }

  @Override
  protected void initialize() {
    if (Math.abs(Robot.driveBase.getLeftSpeed()) > 100 || Math.abs(Robot.driveBase.getRightSpeed()) > 100) return;

    switch (Robot.CAMERA_SUBSYSTEM.getCurrentCamera()) {
      case FRONT:
        Robot.CAMERA_SUBSYSTEM.startStream(CameraSubsystem.Camera.BACK);
        break;
      case BACK:
        Robot.CAMERA_SUBSYSTEM.startStream(CameraSubsystem.Camera.FRONT);
        break;
      default:
        throw new IllegalStateException("Not implemented - what are you even doing");
    }
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
