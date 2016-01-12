package org.usfirst.frc.team1294.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

/**
 * An example {@link Trigger}. Triggers can be used to run a command when something
 * complex happens, such as a joystick being in a specific position while a sensor
 * hits a certain point. Can be used in {@link org.usfirst.frc.team1294.robot.OI}
 * to run a {@link edu.wpi.first.wpilibj.command.Command}.
 */
public class ExampleTrigger extends Trigger {
    /**
     * Whether or not the trigger is considered "active".
     * <p>
     * i.e. if a Command is set to run {@link #whenActive(Command)},
     * the Command will run when this returns {@code true}.
     *
     * @return whether the trigger is considered "active"
     */
    @Override
    public boolean get() {
        return false;
    }
}
