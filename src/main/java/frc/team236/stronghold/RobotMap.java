package frc.team236.stronghold;

public class RobotMap {
	public class Drive {
		public static final int MOTOR_COUNT = 2;
		public static final int DIO_ENCODER_LEFT_A = 0;
		public static final int DIO_ENCODER_LEFT_B = 1;
		public static final int DIO_ENCODER_RIGHT_A = 2;
		public static final int DIO_ENCODER_RIGHT_B = 3;
	}

	public class Arm {
		public static final int PWM_MOTOR = 5;
		public static final int DIO_ENCODER_A = 4;
		public static final int DIO_ENCODER_B = 5;
	}

	public class Shooter {
		public static final int PWM_MOTOR = 7;
		public static final int SOL_FORWARD = 2;
		public static final int SOL_REVERSE = 3;
	}

	public class Intake {
		public static final int PWM_MOTOR = 4;
		public static final int DIO_LIMIT = 8;
	}
}
