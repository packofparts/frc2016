package org.usfirst.frc.team1294.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
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
  private Relay catapultSolenoid;

  public BallHandlingSubsystem() {
    talonCatapult = new CANTalon(0xFFFFFFFF);
    talonBallIntake = new CANTalon(0x000000000);
    catapultSolenoid = new Relay(0x0F0F0F0F);
  }

  // TODO: delete this? not sure if we need this
  public void forwardsCatatpult() {
    talonCatapult.set(CATAPULT_SPEED);
  }

  public void backwardsCatapult() {
    talonCatapult.set(-CATAPULT_SPEED);
  }

  public void setIntakeDirection(IntakeDirection direction) {
    if (direction == IntakeDirection.IN) talonBallIntake.set(INTAKE_SPEED);
    else if (direction == IntakeDirection.OUT) talonBallIntake.set(-INTAKE_SPEED);
    else talonBallIntake.set(0);
  }

  public void intakeSolenoid(boolean on) {
    if (on) catapultSolenoid.set(Relay.Value.kOn);
    else catapultSolenoid.set(Relay.Value.kOff);
  }

  public boolean isCatapultLimitSwitchClosed() {
    return talonCatapult.isRevLimitSwitchClosed();
  }

  @Override
  protected void initDefaultCommand() {
//    setDefaultCommand(Command);
  }

  public void setCatapultBrakeMode(boolean brake) {
    talonCatapult.enableBrakeMode(brake);
  }

  public void stopCatapult() {
    talonCatapult.set(0);
  }

  public enum IntakeDirection {IN, OUT, STOP}
}
