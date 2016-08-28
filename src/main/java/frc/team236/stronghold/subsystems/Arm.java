package frc.team236.stronghold.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team236.stronghold.RobotMap;

public class Arm extends Subsystem {

	private Talon motor;
	public Encoder encoder;

	public Arm() {
		encoder = new Encoder(RobotMap.Arm.DIO_ENCODER_A, RobotMap.Arm.DIO_ENCODER_B);
		motor = new Talon(RobotMap.Arm.PWM_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {

	}

	public void setSpeed(double speed) {
		motor.set(speed);
	}

	public double getRawEncoder() {
		return encoder.getRaw();
	}

	public void zeroEncoder() {
		encoder.reset();
	}
}
