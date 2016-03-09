package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousPositionOneLowGoal extends CommandGroup {

	public AutonomousPositionOneLowGoal() {
		addSequential(new ResetGyro());
		
		// drive straight forward until defense is defeated
		addSequential(new DriveStraightDistance(-0.7, 4.5)); 
		
		// drive angled slightly away from the wall until at turn around point
		addSequential(new TurnToBearing(5));
		addSequential(new DriveStraightDistance(-0.7, .5));
		
		// turn so that back end is pointing roughly at target
		addSequential(new TurnToHeading(250)); // TODO: validate this angle
		
		// aim at the goal, drive forward, aim at the goal, drive forward
		addSequential(new TurnTowardsVisionTarget());
		addSequential(new DriveStraightDistance(0.7, 1));
		addSequential(new TurnTowardsVisionTarget());
		addSequential(new DriveStraightDistance(0.7, 2));
		
		// shoot the ball
		addSequential(new TimedEjectBall(1));
	}
	
}
