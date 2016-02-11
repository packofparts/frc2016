package org.usfirst.frc.team1294.robot.commands;

/**
 * Autonomous command that drives forward a calculated distance, turns to roughly
 * face the castle, uses vision system to fine tune the aim, and shoots. Easy
 * defenses are: Low Bar, Moat, Ramparts, Rock Wall, Rough Terrain
 */
public class AutonomousEasyDefense extends AutonomousReachDefense {
	protected static final double DISTANCE_TO_DEFEAT_DEFENSE = 1.0; // TODO

	public AutonomousEasyDefense(DefensePosition position) {
		super();
		
		addSequential(new DriveStraightDistance(SPEED, DISTANCE_TO_DEFEAT_DEFENSE));
		addSequential(new TurnToBearing(position.bearingToCastle));
		// TODO string together the other commands we need to aim and shoot
	}
}
