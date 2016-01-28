package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@Deprecated
public class TurnToHeading extends Command{
//private double startAngle;
private double desiredAngle;
	public TurnToHeading(double desieredAngle) {
		// TODO Auto-generated constructor stub\
		super("Turn to " + desieredAngle + " degs");
		this.desiredAngle = desieredAngle;
		
		requires (Robot.driveBase);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		//startAngle = Robot.driveTrain.getGyro().getAngle();
		
		
	}

	private double currentAngle() {
		return Robot.driveBase.getRawAngle() % 360;
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
		if (Math.abs(desiredAngle - currentAngle()) > 180)
			Robot.driveBase.tankDrive(0.5, -0.5);
		else 
			Robot.driveBase.tankDrive(-0.5, 0.5);
	}

	@Override
	protected boolean isFinished() {
		SmartDashboard.putNumber("calculatedCurrentAngle", currentAngle());
		SmartDashboard.putNumber("AbsDelta", Math.abs(desiredAngle - currentAngle()));
		// TODO Auto-generated method stub
		return Math.abs(desiredAngle - currentAngle()) < 5;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
