package org.usfirst.frc.team1294.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Austin Jenchi (timtim17)
 */
public class BallHandlingSubsystem extends Subsystem {
  private static final int CATAPULT_SPEED = 1;
  private static final int INTAKE_SPEED = 1;

  private CANTalon talonCatapult;
  private CANTalon talonBallIntake;
  private DigitalInput gearLimitSwitch;
  private Relay gearRelay;

  // TODO: Get proper id numbers
  // TODO: Move ids to RobotMap
  public BallHandlingSubsystem() {
    talonCatapult = new CANTalon(0xFFFFFFFF);
    talonBallIntake = new CANTalon(0x000000000);
    gearRelay = new Relay(0x0F0F0F0F);
    gearLimitSwitch = new DigitalInput(0xF0F0F0F0);
  }

  // TODO: delete this? not sure if we need this
  @Deprecated
  public void forwardsCatatpult() {
    talonCatapult.set(CATAPULT_SPEED);
  }

  public void backwardsCatapult() {
    talonCatapult.set(-CATAPULT_SPEED);
  }

  /**
   * @param direction the direction to move the intake motors in.
   * @deprecated use #setIntake(double) instead.
   */
  @Deprecated
  public void setIntakeDirection(IntakeDirection direction) {
    if (direction == IntakeDirection.IN) talonBallIntake.set(INTAKE_SPEED);
    else if (direction == IntakeDirection.OUT) talonBallIntake.set(-INTAKE_SPEED);
    else talonBallIntake.set(0);
  }

  public void setGear(Relay.Value value) {
    gearRelay.set(value);
  }

  public boolean isCatapultLimitSwitchClosed() {
    return talonCatapult.isRevLimitSwitchClosed();
  }

  public boolean isGearLimitSwitchClosed() {
    return gearLimitSwitch.get();
  }

  @Override
  protected void initDefaultCommand() {
//    setDefaultCommand(Command);
  }

  public void stopCatapult() {
    talonCatapult.set(0);
  }

  public void setIntake(double intake) {
    talonBallIntake.set(intake);
  }

  public void stopIntake() {
    talonBallIntake.set(0);
  }

  /**
   * @deprecated
   */
  @Deprecated
  public enum IntakeDirection {IN, OUT, STOP}
}
