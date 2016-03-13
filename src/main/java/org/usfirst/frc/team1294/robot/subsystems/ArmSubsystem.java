package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.DriveArmWithJoystickCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Austin Jenchi (timtim17)
 */
public class ArmSubsystem extends Subsystem {
  /**
   * A constant used as the {@code x} value to timeout the command, per the proposal.
   */
  public static final double TIMEOUT = 5;
  private static double SPEED = 0.5;

  private CANTalon talon;

  public ArmSubsystem() {
    talon = new CANTalon(RobotMap.spareTalon);
    SmartDashboard.putNumber("arm speed", SPEED);
  }

  private static void updateSpeed() {
    SPEED = SmartDashboard.getNumber("arm speed", 0.5);
  }

  public void forwards() {
    updateSpeed();
    talon.set(SPEED);
  }

  public void backwards() {
    updateSpeed();
    talon.set(-SPEED);
  }

  public void stop() {
    talon.set(0);
  }

  public void setTalon(double input) {
    talon.set(input);
  }

  public boolean isForwardsLimitSwitchClosed() {
    return talon.isFwdLimitSwitchClosed();
  }

  public boolean isBackwardsLimitSwitchClosed() {
    return talon.isRevLimitSwitchClosed();
  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new DriveArmWithJoystickCommand());
  }
}
