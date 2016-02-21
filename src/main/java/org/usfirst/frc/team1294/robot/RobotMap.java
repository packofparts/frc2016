package org.usfirst.frc.team1294.robot;

/**
 * Constants should be defined here, such as CANTalon ids.
 * <p>
 * All values in this file should be {@code public static final}
 * and either {@code int} or {@code double}.
 */
public class RobotMap {
	public static final int leftFrontTalon = 2;
	public static final int leftBackTalon = 1;
	public static final int rightFrontTalon = 3;
	public static final int rightBackTalon = 4;
	public static final int lowerArmTalon = 5;
	public static final int upperArmTalon = 6;
	public static final String driveCamera = "cam2";
	public static final String targetCamera = "cam3";
	public static final double intakeSpeed = 1;
	public static final double catapultSpeed = 1;
	private static final double distanceScaler = 5300;
	private static final double distanceScaler2 = 3533.33;
	// TODO: Get proper id numbers
	public static int catapultTalon = 5;
	public static int intakeTalon = 6;
	public static int catapultGearTalon = 7;
	public static int gearLimitSwitch = 1;

	public static double getDistanceScaler() {
		if (Robot.getWhichRobot() == Robot.WhichRobot.ROBOT_1) return distanceScaler;
		else return distanceScaler2;
	}
}
