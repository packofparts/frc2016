package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SquareAutonomousCommand extends CommandGroup{
	public SquareAutonomousCommand(){
		addSequential(new DriveStraightDistance(1, 0.5));
		addSequential(new TurnCommand(90));
		addSequential(new DriveStraightDistance(1, 0.5));
		addSequential(new TurnCommand(90));
		addSequential(new DriveStraightDistance(1, 0.5));
		addSequential(new TurnCommand(90));
		addSequential(new DriveStraightDistance(1, 0.5));
		addSequential(new TurnCommand(90));
	}
}