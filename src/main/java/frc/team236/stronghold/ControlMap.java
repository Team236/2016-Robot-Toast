package frc.team236.stronghold;

public class ControlMap {
	public static final int PORT_STICK_LEFT = 0;
	public static final int PORT_STICK_RIGHT = 1;
	public static final int PORT_CONTROLLER = 2;

	public class LeftStick {
	}

	public class RightStick {

	}

	public class Controller {
		public static final int AXIS_ARM = LogitechF310.Axes.LEFT_Y;
		public static final int ENABLE_JOYSTICK = LogitechF310.LEFT_PRESS;
	}
}