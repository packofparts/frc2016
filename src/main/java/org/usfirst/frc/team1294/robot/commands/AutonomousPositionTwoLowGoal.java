package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousPositionTwoLowGoal extends CommandGroup {

	public AutonomousPositionTwoLowGoal() {
		addSequential(new ResetGyro());
		addSequential(new WaitCommand(0.5));
		
		// drive straight forward until at aiming point
		addSequential(new DriveStraightDistance(-0.8, 7.9)); // TODO: measure this distance
		
		// turn so that back end is pointing roughly at target
		addSequential(new TurnToHeading(268)); // TODO: validate this angle
		
		// aim at the goal, drive forward, aim at the goal, drive forward
		//addSequential(new WaitCommand(1));
		addSequential(new TurnTowardsVisionTarget());
		addSequential(new DriveStraightDistance(0.8, 2));
		
		
		// shoot the ball
		addSequential(new TimedEjectBall(1));
	}
}
