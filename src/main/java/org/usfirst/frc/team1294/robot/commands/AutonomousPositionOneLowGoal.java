package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousPositionOneLowGoal extends CommandGroup {

	public AutonomousPositionOneLowGoal() {
		
		// drive straight forward until defense is defeated
		addSequential(new DriveStraightDistance(-0.8, 5)); 
		
		// drive angled slightly away from the wall until at turn around point
		addSequential(new DrivePid(5, -0.8, 1)); // TODO: measure this distance
		
		// turn so that back end is pointing roughly at target
		addSequential(new TurnToHeading(225)); // TODO: validate this angle
		
		// aim at the goal
		addSequential(new TurnTowardsVisionTarget());
		addSequential(new WaitCommand(1));
		addSequential(new TurnTowardsVisionTarget());
		
		// drive until at goal shooting distance
		addSequential(new DriveStraightDistance(0.8, 1)); // TODO: measure this distance
		
		// shoot the ball
		addSequential(new TimedEjectBall(1));
	}
	
}
