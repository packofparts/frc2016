package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.subsystems.Vision;

public class TurnTowardsVisionTarget extends TurnToBearing {
	private static final double FOV = 60;
	private static final double WIDTH = 640;
	private static final double DEGREES_PER_PIXEL = FOV / WIDTH;
	private static final double MAX_AGE_OF_VISION_DATA = 1000;
	
	private final Vision vision;

	// TODO: Refactor into CommandBase and remove parameter
	public TurnTowardsVisionTarget(Vision visionSubsystem) {
		super(0);
		this.requires(visionSubsystem);
		vision = visionSubsystem;
	}

	@Override
	protected void initialize() {
		if (vision.getTimeSinceLastUpdate() <= MAX_AGE_OF_VISION_DATA && vision.isTargetAcquired()) {
			bearing = (vision.getTargetX() - WIDTH / 2) * DEGREES_PER_PIXEL;
//			System.out.println(vision.getTargetX());
//			System.out.println(bearing);
		}
		super.initialize();
	}
	
	
}
