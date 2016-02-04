package org.usfirst.frc.team1294.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * A subsystem that handles the streaming of the camera to the driver station.
 *
 * @author Austin Jenchi (timtim17)
 * @see org.usfirst.frc.team1294.robot.commands.SetCameraCommand
 */
public class CameraSubsystem extends Subsystem {
  private static CameraServer cameraServer = CameraServer.getInstance();

  private int quality;

  /**
   * {@inheritDoc}
   *
   * <p>Sets default quality at 50%.</p>
   */
  public CameraSubsystem() {
    this(50);
  }

  /**
   * Sets up a {@link CameraServer} with the passed in quality.
   *
   * @param quality The passed in quality.
   */
  public CameraSubsystem(final int quality) {
    super("Camera");
    setQuality(quality);
  }

  /**
   * Starts the stream with the default camera ({@code "cam0"}).
   *
   * @see #startStream(String)
   */
  public void startStream() {
    startStream("cam0");
  }

  /**
   * Starts the stream with the passed in camera name.
   *
   * <p>Camera names can be found on webdash ({@code roboRIO-TEAM-frc.local}).</p>
   *
   * @param camName The name of the camera to stream.
   */
  public void startStream(final String camName) {
    cameraServer.startAutomaticCapture(camName);
  }

  @Override
  protected void initDefaultCommand() {
    // setDefaultCommand();
  }

  /**
   * Gets the quality of the stream.
   *
   * @return The quality of the stream from 0% to 100%.
   */
  public int getQuality() {
    return quality;
  }

  /**
   * Sets the quality of the stream. If the quality is less than 0% or more than 100%, the quality
   * is normalized.
   *
   * @param quality The quality of the camera stream.
   */
  public void setQuality(int quality) {
    if (quality < 0) quality = 0;
    else if (quality > 100) quality = 100;

    this.quality = quality;
    cameraServer.setQuality(quality);
  }
}
