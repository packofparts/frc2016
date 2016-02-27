//package org.usfirst.frc.team1294.robot.commands;
//
//import org.usfirst.frc.team1294.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//
//public class ArmCommand extends Command {
//
//	private static final double DEADZONE = 0.02;
//
//	public ArmCommand() {
//		requires(Robot.armSubsystem);
//	}
//	@Override
//	protected void initialize() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	protected void execute() {
//		//double deadZone = DEADZONE;
//		
//		double upperJointInput = Robot.oi.getMechStickOne().getRawAxis(1);
//		if (Math.abs(upperJointInput) < DEADZONE)
//			upperJointInput = 0;
//		
//		double lowerJointInput = Robot.oi.getMechStickOne().getRawAxis(5);
//		if (Math.abs(lowerJointInput) < DEADZONE)
//			lowerJointInput = 0;
//	
//		double upperJointOutput = upperJointInput * 0.05;
//		double lowerJointOutput = lowerJointInput * 0.5;
//		
//		Robot.armSubsystem.upperArmTalon.set(upperJointOutput);
//		Robot.armSubsystem.lowerArmTalon.set(lowerJointOutput);
//		
//	}
//
//	@Override
//	protected boolean isFinished() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	protected void end() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	protected void interrupted() {
//		// TODO Auto-generated method stub
//
//	}
//
//}
