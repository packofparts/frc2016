package org.usfirst.frc.team1294.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;

import org.usfirst.frc.team1294.robot.commands.TankDriveWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.
 */
public class DriveSystem extends Subsystem {
	public CANTalon leftFrontTalon;
	public CANTalon rightFrontTalon;
	public CANTalon leftBackTalon;
	public CANTalon rightBackTalon;
	public RobotDrive drive;
	
    public DriveSystem() {
        // Set left feedback device and talon numbers
    	leftFrontTalon = new CANTalon(1);
    	//leftFrontTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	leftBackTalon = new CANTalon(3);
    	// Set right feedback device and talon numbers
    	rightFrontTalon = new CANTalon(2);
    	//rightFrontTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	//rightBackTalon = new CANTalon(4);
    	leftFrontTalon.setInverted(true);
    	//leftBackTalon.reverseOutput(true);
    	rightFrontTalon.setInverted(true);
    	//set left back talon to slave mode
    	leftBackTalon.changeControlMode(CANTalon.TalonControlMode.Follower);
    	leftBackTalon.set(leftFrontTalon.getDeviceID());
    	//set right back talon to slave mode
    	rightBackTalon.changeControlMode(CANTalon.TalonControlMode.Follower);
    	rightBackTalon.set(rightFrontTalon.getDeviceID());
    	drive = new RobotDrive(leftFrontTalon, rightFrontTalon);
    	
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDriveWithJoystick());
    }
    
    public void tankDrive(Joystick left, Joystick right) {
		drive.tankDrive(left, right);
	}
}
