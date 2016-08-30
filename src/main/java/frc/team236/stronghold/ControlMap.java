package frc.team236.stronghold;

public class ControlMap {
	public static final int PORT_STICK_LEFT = 0;
	public static final int PORT_STICK_RIGHT = 1;
	public static final int PORT_CONTROLLER = 2;

	public class LeftStick {
		public static final int EJECT = 2;
		public static final int INTAKE = 3;
		public static final int COCK = 4;
		public static final int INTAKE_OVERRIDE = 5;
	}

	public class RightStick {
		public static final int SHIFT_DOWN = 2;
		public static final int SHIFT_UP = 3;
	}

	public class Controller {
		public static final int AXIS_ARM = LogitechF310.Axes.LEFT_Y;
		public static final int ENABLE_JOYSTICK = LogitechF310.LEFT_PRESS;
		public static final int ARM_BOTTOM = LogitechF310.A;

		public static final int CLIMB = LogitechF310.LB;

		public static final int SHOOT = LogitechF310.RB;

		public static final int FIX_DRIVE = LogitechF310.START;
	}
}
