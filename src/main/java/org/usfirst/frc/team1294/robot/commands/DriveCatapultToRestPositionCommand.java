//package org.usfirst.frc.team1294.robot.commands;
//
//import org.usfirst.frc.team1294.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// * @author Austin Jenchi (timtim17)
// */
//public class DriveCatapultToRestPositionCommand extends Command {
//  public DriveCatapultToRestPositionCommand() {
//    requires(Robot.ballHandleSubsystem);
//  }
//
//  @Override
//  protected void initialize() {
//    Robot.ballHandleSubsystem.backwardsCatapult();
//  }
//
//  @Override
//  protected void execute() {
//
//  }
//
//  @Override
//  protected boolean isFinished() {
//    return Robot.ballHandleSubsystem.isCatapultLimitSwitchClosed();
//  }
//
//  @Override
//  protected void end() {
//    Robot.ballHandleSubsystem.stopCatapult();
//  }
//
//  @Override
//  protected void interrupted() {
//    end();
//  }
//}
