package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.MoveUpperArmMotor;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSubsystem extends Subsystem{
	public CANTalon lowerArmTalon;
	public CANTalon upperArmTalon;
	//private AnalogInput linear;

	public ArmSubsystem() {
		// TODO Auto-generated constructor stub
		lowerArmTalon = new CANTalon(RobotMap.lowerArmTalon);
		upperArmTalon = new CANTalon(RobotMap.upperArmTalon);
		//AnalogInput linearPotentiometer = new AnalogInput(4);
		//linear = linearPotentiometer;
		lowerArmTalon.setFeedbackDevice(FeedbackDevice.AnalogPot);
		lowerArmTalon.changeControlMode(CANTalon.TalonControlMode.Position);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new MoveUpperArmMotor());
	}
	public void moveLowerMotor(Joystick one){
		lowerArmTalon.set(one.getY()*0.5);
	}
	public void moveUpperMotor(Joystick one){
		upperArmTalon.set(one.getY()*0.05);
	}

}
