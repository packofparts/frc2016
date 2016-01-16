package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command.
 */
public class ExampleCommand extends Command {
    public ExampleCommand() {
    	super("drive for 1800 seconds");
       requires(Robot.Drive_System);
       
       
       
    }

    /**
     * Runs after {@link #start()} is called but before {@link #execute()}.
     * Initialize variables, setup subsystems (i.e. Talon brake mode), or do things
     * that should run once (i.e. {@code initialize()} is called, and then {@link #isFinished()}
     * returns true to immediately end the command.
     */
    @Override
    protected void initialize() {
    	Robot.Drive_System.drive.setSafetyEnabled(false);
    	Robot.Drive_System.drive.arcadeDrive(1,0);
    	setTimeout(1800);
    	
    }

    /**
     * Called periodically while {@link #isFinished()} returns {@code false}.
     */
    @Override
    protected void execute() {}

    /**
     * Returns true if the command is ready to end.
     *
     * @return whether or not the command is ready to end
     */
    
    @Override
    protected boolean isFinished() {
       return isTimedOut();
    }

    /**
     * Called after {@link #isFinished()} returns {@link true}.
     * Use this to do things such as stopping motors.
     */
    @Override
    protected void end() {
    	Robot.Drive_System.drive.arcadeDrive(0, 0);
    	Robot.Drive_System.drive.setSafetyEnabled(true);
    }

    /**
     * Called if the command does not end normally, such as if {@link #cancel()} is called.
     * It is generally a good idea to call {@link #end()} in this method.
     */
    @Override
    protected void interrupted() {
    	end();
    }
}
