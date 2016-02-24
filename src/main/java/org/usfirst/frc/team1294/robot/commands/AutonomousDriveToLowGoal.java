package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDriveToLowGoal extends CommandGroup{
	protected static final double SPEED = -0.5;
	public AutonomousDriveToLowGoal(DefensePosition position){
		// TODO Auto-generated constructor stub
		addSequential(new AutonomousEasyDefense(position));
		if(position.distanceToWall > 0){
			addSequential(new TurnToBearing(90));
			addSequential(new DriveStraightDistance(SPEED, 9.875));
			
		}
		else if(position.distanceToWall < 0){
			addSequential(new TurnToBearing(270));
			addSequential(new DriveStraightDistance(SPEED, 9.875));
			addSequential(new TurnToBearing(30));
		}
		else{
			addSequential(new DriveStraightDistance(SPEED, 9.875));
			addSequential(new TurnToBearing(30));
		}
	}

}
