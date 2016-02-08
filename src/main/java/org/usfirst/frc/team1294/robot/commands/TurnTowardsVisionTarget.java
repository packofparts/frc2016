package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.subsystems.Vision;

public class TurnTowardsVisionTarget extends DrivePid {
	private static final double FOV = 53.50;
	private static final double WIDTH = 640;
	private static final double DEGREES_PER_PIXEL = FOV / WIDTH;
	private static final double MAX_AGE_OF_VISION_DATA = 1000;
	
	private final Vision vision;
	
	public TurnTowardsVisionTarget() {
		super(0);
		this.requires(Robot.visionSubsystem);
		vision = Robot.visionSubsystem;
	}

	@Override
	protected void initialize() {
		if (vision.getTimeSinceLastUpdate() <= MAX_AGE_OF_VISION_DATA && vision.isTargetAcquired()) {
			double bearing = (vision.getTargetX() - WIDTH / 2) * DEGREES_PER_PIXEL;
			heading = driveBase.getNormalizedAngle() + bearing;
		}
		
		super.initialize();
	}
	
	
}
