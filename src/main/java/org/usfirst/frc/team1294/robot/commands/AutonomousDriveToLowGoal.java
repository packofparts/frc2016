package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDriveToLowGoal extends CommandGroup{
	protected static final double SPEED = -0.5;
	public AutonomousDriveToLowGoal(DefensePosition position){
		// TODO Auto-generated constructor stub
		addSequential(new AutonomousEasyDefense(position));
		if(position.distanceToWall > 0){
			addSequential(new TurnToBearing(90));
			addSequential(new DriveStraightDistance(SPEED, position.distanceToWall));
			addSequential(new TurnToBearing(0));
			addSequential(new DriveStraightDistance(SPEED, 4));
			addSequential(new TurnToBearing(300));
			
		}
		else if(position.distanceToWall < 0){
			addSequential(new TurnToBearing(270));
			addSequential(new DriveStraightDistance(SPEED, position.distanceToWall*-1));
			addSequential(new TurnToBearing(0));
			addSequential(new DriveStraightDistance(SPEED, 4));
			addSequential(new TurnToBearing(30));
		}
		else{
			addSequential(new DriveStraightDistance(SPEED, 4));
			addSequential(new TurnToBearing(30));
		}
		addSequential(new TimedEjectBall(30));
	}

}
