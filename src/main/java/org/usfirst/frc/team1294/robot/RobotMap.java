package org.usfirst.frc.team1294.robot;

/**
 * Constants should be defined here, such as CANTalon ids.
 * <p>
 * All values in this file should be {@code public static final}
 * and either {@code int} or {@code double}.
 */
public class RobotMap {
	public static int leftFrontTalon = 2;
	public static int leftBackTalon = 1;
	public static int rightFrontTalon = 3;
	public static int rightBackTalon = 4;
	public static int lowerArmTalon = 5;
	public static int upperArmTalon = 6;
	public static String driveCamera = "cam2";
	public static String targetCamera = "cam3";
	private static double distanceScaler = 5300;
	private static double distanceScaler2 = 3533.33;

	public static double getDistanceScaler() {
		if (Robot.getWhichRobot() == Robot.WhichRobot.ROBOT_1) return distanceScaler;
		else return distanceScaler2;
	}
}
