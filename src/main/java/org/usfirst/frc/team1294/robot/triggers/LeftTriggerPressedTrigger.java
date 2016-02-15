package org.usfirst.frc.team1294.robot.triggers;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * @author Austin Jenchi (timtim17)
 */
public class LeftTriggerPressedTrigger extends Trigger {
  private static final double DEADZONE = 0.01;

  @Override
  public boolean get() {
    return Robot.oi.getMechStickOne().getRawAxis(2) > DEADZONE;
  }
}
