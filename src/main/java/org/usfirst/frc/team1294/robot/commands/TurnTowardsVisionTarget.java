package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

public class TurnTowardsVisionTarget extends TurnToBearing {
	private static final double FOV = 60;
	private static final double WIDTH = 640;
	private static final double DEGREES_PER_PIXEL = FOV / WIDTH;
	private static final double MAX_AGE_OF_VISION_DATA = 1000;

	public TurnTowardsVisionTarget() {
		super(0);
		this.requires(Robot.vision);
	}

	@Override
	protected void initialize() {
		if (Robot.vision.getTimeSinceLastUpdate() <= MAX_AGE_OF_VISION_DATA && Robot.vision.isTargetAcquired()) {
			bearing = (Robot.vision.getTargetX() - WIDTH / 2) * DEGREES_PER_PIXEL;
		}
		super.initialize();
	}
	
	
}
