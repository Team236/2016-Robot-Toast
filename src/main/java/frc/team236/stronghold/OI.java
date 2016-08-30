package frc.team236.stronghold;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team236.stronghold.commands.arm.ArmWithJoystick;

public class OI {
	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick controller;

	public Button shiftUp;
	public Button shiftDown;
	public Button intake;
	public Button eject;
	public Button shoot;
	public Button cock;
	public Button armWithJoystick;
	public Button goBottom;
	/*
	public Button goNearBatterHighShotAngle;
	public Button goDefenseHighShotAngle;
	public Button goFarBatterHighShotAngle;
	*/
	public Button controllerShoot;
	public Button controllerIntake;
	public Button intakeOverride;
	public Button hangerUp;
	public Button fixDrive;

	public OI() {
		leftStick = new Joystick(ControlMap.PORT_STICK_LEFT);
		rightStick = new Joystick(ControlMap.PORT_STICK_RIGHT);
		controller = new Joystick(ControlMap.PORT_CONTROLLER);

		armWithJoystick = new JoystickButton(controller, ControlMap.Controller.ENABLE_JOYSTICK);
		armWithJoystick.whileHeld(new ArmWithJoystick());
	}
}