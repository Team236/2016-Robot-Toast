package frc.team236.stronghold;

import frc.team236.pid.PIDParameters;
import frc.team236.ticktank.ControllerType;

public class RobotMap {
	public static class Drive {
		public static final int MOTOR_COUNT = 2;
		public static final int DIO_ENCODER_LEFT_A = 0;
		public static final int DIO_ENCODER_LEFT_B = 1;
		public static final int DIO_ENCODER_RIGHT_A = 2;
		public static final int DIO_ENCODER_RIGHT_B = 3;

		private static final double CIRCUMFERENCE = 28;
		public static final double DISTANCE_PER_PULSE = CIRCUMFERENCE / (3 * 512);

		public static final boolean INV_LEFT_MOTORS = false;
		public static final boolean INV_RIGHT_MOTORS = false;

		public static final boolean INV_LEFT_ENCODER = false;
		public static final boolean INV_RIGHT_ENCODER = true;

		public static final int SOL_FORWARD = 0;
		public static final int SOL_REVERSE = 1;

		public static final ControllerType MOTOR_TYPE = ControllerType.VICTORSP;
	}

	public static class Arm {
		public static final int PWM_MOTOR = 5;
		public static final boolean INV_MOTOR = false;

		public static final int DIO_ENCODER_A = 4;
		public static final int DIO_ENCODER_B = 5;
		public static final boolean INV_ENCODER = false;
		public static final double DISTANCE_PER_PULSE = 1;

		public static final int DIO_LIMIT_TOP = 6;
		public static final int DIO_LIMIT_BOTTOM = 7;

		public static final PIDParameters GAINS = new PIDParameters(0.001, 0, 0, 1 / 200.0);

		public static final int TOP_RAW = 6600;
		public static final int BOTTOM_RAW = 0;
	}

	public static class Shooter {
		public static final int PWM_MOTOR = 7;
		public static final boolean INV_MOTOR = false;

		public static final int SOL_FORWARD = 2;
		public static final int SOL_REVERSE = 3;
	}

	public static class Intake {
		public static final int PWM_MOTOR = 4;
		public static final boolean INV_MOTOR = false;
		public static final int DIO_LIMIT = 8;
	}

	public static class Climber {
		public static final int PWM_MOTOR = 6;
		public static final boolean INV_MOTOR = false;
	}
}
