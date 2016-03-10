package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousPositionOneLowGoal extends CommandGroup {

	public AutonomousPositionOneLowGoal() {
		addSequential(new ResetGyro());
		
		// drive straight forward until defense is defeated
		addSequential(new DriveStraightDistance(-0.8, 6.5)); 
		
		// drive angled slightly away from the wall until at turn around point
		//addSequential(new TurnToHeading(30));
		//addSequential(new DriveStraightDistance(-0.8, .25));
		
		// turn so that back end is pointing roughly at target
		addSequential(new TurnToHeading(255)); // TODO: validate this angle
		addSequential(new DriveStraightDistance(0.8, 2.5));
		
		// aim at the goal, drive forward, aim at the goal, drive forward
		//
		//addSequential(new TurnTowardsVisionTarget());
		addSequential(new DriveStraightDistance(0.8, 1));
		//addSequential(new TurnTowardsVisionTarget());
		//addSequential(new DriveStraightDistance(0.8, 1.25));
		
		// shoot the ball
		addSequential(new TimedEjectBall(1));
	}
	
}
