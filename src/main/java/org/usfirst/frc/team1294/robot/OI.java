package org.usfirst.frc.team1294.robot;

import org.usfirst.frc.team1294.robot.commands.EjectBallCommand;
import org.usfirst.frc.team1294.robot.commands.LaunchBallCommand;
import org.usfirst.frc.team1294.robot.commands.MoveUpperArmMotor;
import org.usfirst.frc.team1294.robot.commands.SetCameraCommand;
import org.usfirst.frc.team1294.robot.commands.SquareAutonomousCommand;
import org.usfirst.frc.team1294.robot.commands.SwitchCameraCommand;
import org.usfirst.frc.team1294.robot.commands.WallFollowing;
import org.usfirst.frc.team1294.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1294.robot.triggers.LeftTriggerPressedTrigger;
import org.usfirst.frc.team1294.robot.triggers.RightTriggerPressedTrigger;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	Joystick stickLeft = new Joystick(0);
	Button leftButton1 = new JoystickButton(stickLeft, 7);
	Button leftButton6 = new JoystickButton(stickLeft, 6);
	Button leftButton10 = new JoystickButton(stickLeft, 10);
	Joystick stickRight = new Joystick(1);
	Button cam1 = new JoystickButton(stickLeft, 2);
	Button cam2 = new JoystickButton(stickLeft, 4);
	Button switchCam = new JoystickButton(stickLeft, 3);
	Button otherSwitchCam = new JoystickButton(stickRight, 3);
	Joystick mechStickOne = new Joystick(3);
	Button mechButtonX = new JoystickButton(mechStickOne, 3);
	Button mechButtonA = new JoystickButton(mechStickOne, 1);
	Trigger leftPressed = new LeftTriggerPressedTrigger();
	Trigger rightPressed = new RightTriggerPressedTrigger();
	Button mechRightButton = new JoystickButton(mechStickOne, 6);

	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	public OI() {
//		leftButton1.toggleWhenPressed(new DriveStraightDistance(1, 0.5));
		leftButton6.toggleWhenPressed(new WallFollowing());
		leftButton10.toggleWhenPressed(new SquareAutonomousCommand());
		
		//stickLeft.
		cam1.whenPressed(new SetCameraCommand(CameraSubsystem.Camera.FRONT));
		cam2.whenPressed(new SetCameraCommand(CameraSubsystem.Camera.BACK));
		switchCam.whenPressed(new SwitchCameraCommand());
		otherSwitchCam.whenPressed(new SwitchCameraCommand());

		mechButtonX.toggleWhenPressed(new MoveUpperArmMotor());
		leftPressed.whileActive(new EjectBallCommand());
		rightPressed.whileActive(new IntakeBallCommand());
		mechButtonA.whenPressed(new LaunchBallCommand());
//		mechRightButton.toggleWhenPressed(new );
	}
	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released  and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public Joystick getStickLeft() {
		return stickLeft;
	}

	public Joystick getStickRight() {
		return stickRight;
	}
	public Joystick getMechStickOne(){
		return mechStickOne;
	}
}
