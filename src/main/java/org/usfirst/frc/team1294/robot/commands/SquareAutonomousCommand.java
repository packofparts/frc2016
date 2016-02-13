package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SquareAutonomousCommand extends CommandGroup{
	public SquareAutonomousCommand(){		
		addSequential(new DrivePid(0, 1));
		addSequential(new DrivePid(90, 0));
		addSequential(new DrivePid(90, 1));
		addSequential(new DrivePid(180, 0));
		addSequential(new DrivePid(180, 1));
		addSequential(new DrivePid(270, 0));
		addSequential(new DrivePid(270, 1));
		addSequential(new DrivePid(0, 0));
	}
}