package org.usfirst.frc.team1294.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
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
        // do something
    	leftFrontTalon = new CANTalon(1);
    	leftBackTalon = new CANTalon(2);
    	rightFrontTalon = new CANTalon(3);
    	rightBackTalon = new CANTalon(4);
    	drive = new RobotDrive(leftFrontTalon, leftBackTalon, rightFrontTalon, rightBackTalon );
    	
    }

    @Override
    protected void initDefaultCommand() {
        // setDefaultCommand(Command)
    }
}
