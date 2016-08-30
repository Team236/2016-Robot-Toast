package frc.team236.stronghold;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick controller;

	public OI() {
		leftStick = new Joystick(ControlMap.PORT_STICK_LEFT);
		rightStick = new Joystick(ControlMap.PORT_STICK_RIGHT);
		controller = new Joystick(ControlMap.PORT_CONTROLLER);
	}
}