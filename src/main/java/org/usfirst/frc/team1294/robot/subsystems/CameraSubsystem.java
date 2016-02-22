package org.usfirst.frc.team1294.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.StreamCameraCommand;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * A subsystem that handles the streaming of the camera to the driver station.
 *
 * @author Austin Jenchi (timtim17)
 * @see org.usfirst.frc.team1294.robot.commands.SetCameraCommand
 */
public class CameraSubsystem extends Subsystem {
  //  public static final float RED = 0x0000FF;
//  public static final float BLUE = 0xFF0000;
//  private static /* final */ int BORDER_SIZE = 10;
//  private static final int WIDTH = 640;
//  private static final int HEIGHT = 480;
//
//  private static NIVision.Rect BORDER_TOP = new NIVision.Rect(0, 0, WIDTH, BORDER_SIZE);
//  private static NIVision.Rect BORDER_LEFT = new NIVision.Rect(0, 0, BORDER_SIZE, HEIGHT);
//  private static NIVision.Rect BORDER_BOTTOM = new NIVision.Rect(0, HEIGHT - BORDER_SIZE, WIDTH, BORDER_SIZE);
//  private static NIVision.Rect BORDER_RIGHT = new NIVision.Rect(WIDTH - BORDER_SIZE, 0, BORDER_SIZE, HEIGHT);
  private static CameraServer cameraServer = CameraServer.getInstance();
  private static USBCamera driveCamera, targetCamera, piCamera;
  private static boolean initCameras = false;

  private Camera currentCamera;
  private Image frame;
  private int quality;

  /**
   * {@inheritDoc}
   *
   * <p>Sets default quality at 30%.</p>
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
//    SmartDashboard.putNumber("border width", 10);
  }

  public static void initCameras() {
    if (initCameras) return;

    driveCamera = new USBCamera(RobotMap.driveCamera);
    targetCamera = new USBCamera(RobotMap.targetCamera);
//    piCamera = new USBCamera("cam2");

    driveCamera.setExposureHoldCurrent();
    targetCamera.setExposureHoldCurrent();

    driveCamera.setWhiteBalanceHoldCurrent();
    driveCamera.setWhiteBalanceHoldCurrent();

    initCameras = true;

    driveCamera.startCapture();
    targetCamera.startCapture();
  }

  /**
   * Starts the stream with the default camera.
   *
   * @see #startStream(Camera)
   */
  public void startStream() {
    startStream(Camera.FRONT);
  }

  /**
   * Starts the stream with the passed in camera.
   *
   * @param camera The camera to stream.
   */
  public void startStream(final Camera camera) {
    currentCamera = camera;
//    switch (camera) {
//      case FRONT:
//        driveCamera.startCapture();
//        targetCamera.stopCapture();
////        piCamera.stopCapture();
//        break;
//      case BACK:
//        driveCamera.stopCapture();
//        targetCamera.startCapture();
////        piCamera.stopCapture();
//        break;
//      case PI:
//        throw new IllegalStateException("Pi camera not implemented");
//    }
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
        // TODO: Borders and text
//        drawBorder(RED);
        break;
      case PI:
        throw new IllegalStateException("Pi camera not implemented");
    }

    SmartDashboard.putBoolean("REVERSE", currentCamera == Camera.BACK);

    cameraServer.setImage(frame);
  }

  private void drawBorder(final float color) {
//    BORDER_SIZE = (int) SmartDashboard.getNumber("border width", 10);

//    NIVision.imaqDrawShapeOnImage(frame, frame, BORDER_TOP, NIVision.DrawMode.PAINT_VALUE,
//            NIVision.ShapeMode.SHAPE_RECT, color);
//    NIVision.imaqDrawShapeOnImage(frame, frame, BORDER_LEFT, NIVision.DrawMode.PAINT_VALUE,
//            NIVision.ShapeMode.SHAPE_RECT, color);
//    NIVision.imaqDrawShapeOnImage(frame, frame, BORDER_BOTTOM, NIVision.DrawMode.PAINT_VALUE,
//            NIVision.ShapeMode.SHAPE_RECT, color);
//    NIVision.imaqDrawShapeOnImage(frame, frame, BORDER_RIGHT, NIVision.DrawMode.PAINT_VALUE,
//            NIVision.ShapeMode.SHAPE_RECT, color);
//    NIVision.imaqOverlayText(frame, new NIVision.Point(0, 0), "REVERSE", NIVision.RGB_RED, new NIVision.OverlayTextOptions("Arial", 12, 1, 0, 0, 0, NIVision.TextAlignment.LEFT, NIVision.VerticalTextAlignment.BASELINE, NIVision.RGB_WHITE, 0), "text");
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
