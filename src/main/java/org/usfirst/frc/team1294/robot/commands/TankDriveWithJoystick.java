package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1294.robot.Robot;

/**
 * Have the robot drive tank style using the PS3 Joystick until interrupted.
 */
public class TankDriveWithJoystick extends Command {
    
    public TankDriveWithJoystick() {
        requires(Robot.driveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveBase.tankDrive(Robot.oi.getStickLeft().getY(), Robot.oi.getStickRight().getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // Runs until interrupted
    }

    // Called once after isFinished returns true
    protected void end() {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}