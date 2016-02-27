//package org.usfirst.frc.team1294.robot.subsystems;
//
//import org.usfirst.frc.team1294.robot.RobotMap;
//import org.usfirst.frc.team1294.robot.commands.ArmCommand;
//
//import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
//public class ArmSubsystem extends Subsystem{
//	public CANTalon lowerArmTalon;
//	public CANTalon upperArmTalon;
//	//private AnalogInput linear;
//
//	public ArmSubsystem() {
//		// TODO Auto-generated constructor stub
//		lowerArmTalon = new CANTalon(RobotMap.lowerArmTalon);
//		upperArmTalon = new CANTalon(RobotMap.upperArmTalon);
//		//AnalogInput linearPotentiometer = new AnalogInput(4);
//		//linear = linearPotentiometer;
//		lowerArmTalon.setFeedbackDevice(FeedbackDevice.AnalogPot);
//		lowerArmTalon.changeControlMode(CANTalon.TalonControlMode.Position);
//		upperArmTalon.setInverted(true);
//		lowerArmTalon.setInverted(true);
//	}
//
//	@Override
//	protected void initDefaultCommand() {
//		// TODO Auto-generated method stub
//		setDefaultCommand(new ArmCommand());
//	}
//	public void moveLowerMotor(double value){
//		//lowerArmTalon.set(one.getRawAxis(1)*0.5);
//		lowerArmTalon.set(value);
//	}
//	public void moveUpperMotor(double value){
//		//upperArmTalon.set(one.getRawAxis(1)*0.05);
//		upperArmTalon.set(value);
//	}
//
//}
