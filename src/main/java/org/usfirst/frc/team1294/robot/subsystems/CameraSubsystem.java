package org.usfirst.frc.team1294.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import org.usfirst.frc.team1294.robot.commands.StreamCameraCommand;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * A subsystem that handles the streaming of the camera to the driver station.
 *
 * @author Austin Jenchi (timtim17)
 * @see org.usfirst.frc.team1294.robot.commands.SetCameraCommand
 */
public class CameraSubsystem extends Subsystem {
  private static CameraServer cameraServer = CameraServer.getInstance();
  private static USBCamera driveCamera, targetCamera, piCamera;
  private static boolean initCameras = false;

  private Camera currentCamera;
  private Image frame;
  private int quality;

  /**
   * {@inheritDoc}
   *
   * <p>Sets default quality at 50%.</p>
   */
  public CameraSubsystem() {
    this(30);
  }

  /**
   * Sets up a {@link CameraServer} with the passed in quality.
   *
   * @param quality The passed in quality.
   */
  public CameraSubsystem(final int quality) {
    super("Camera");
    setQuality(quality);
    frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
  }

  public static void initCameras() {
    if (initCameras) return;

    driveCamera = new USBCamera("cam0");
    targetCamera = new USBCamera("cam1");
//    piCamera = new USBCamera("cam2");

    initCameras = true;
  }

  /**
   * Starts the stream with the default camera ({@code "cam0"}).
   *
   * @see #startStream(Camera)
   */
  public void startStream() {
    startStream(Camera.FRONT);
  }

  /**
   * Starts the stream with the passed in camera name.
   *
   * <p>Camera names can be found on webdash ({@code roboRIO-TEAM-frc.local}).</p>
   *
   * @param camera The name of the camera to stream.
   */
  public void startStream(final Camera camera) {
    currentCamera = camera;
    switch (camera) {
      case FRONT:
        driveCamera.startCapture();
        targetCamera.stopCapture();
//        piCamera.stopCapture();
        break;
      case BACK:
        driveCamera.stopCapture();
        targetCamera.startCapture();
//        piCamera.stopCapture();
        break;
      case PI:
        throw new IllegalStateException("Pi camera not implemented");
    }
  }

  public void stream() {
    if (!initCameras) {
      initCameras();
      startStream();
    }

    switch (currentCamera) {
      case FRONT:
        driveCamera.getImage(frame);
        break;
      case BACK:
        targetCamera.getImage(frame);
        break;
      case PI:
        throw new IllegalStateException("Pi camera not implemented");
    }
    cameraServer.setImage(frame);
  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new StreamCameraCommand());
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

  public Camera getCurrentCamera() {
    return currentCamera;
  }

  public enum Camera {FRONT, BACK, PI}
}
