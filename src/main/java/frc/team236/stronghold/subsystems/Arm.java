package frc.team236.stronghold.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team236.stronghold.RobotMap;

public class Arm extends Subsystem {

	private SpeedController motor;
	public Encoder encoder;
	private DigitalInput top, bottom;

	public Arm() {
		motor = new Talon(RobotMap.Arm.PWM_MOTOR);
		motor.setInverted(RobotMap.Arm.INV_MOTOR);

		encoder = new Encoder(RobotMap.Arm.DIO_ENCODER_A, RobotMap.Arm.DIO_ENCODER_B);
		encoder.setDistancePerPulse(RobotMap.Arm.DISTANCE_PER_PULSE);

		top = new DigitalInput(RobotMap.Arm.DIO_LIMIT_TOP);
		bottom = new DigitalInput(RobotMap.Arm.DIO_LIMIT_BOTTOM);
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

	public double getEncoderDistance() {
		return encoder.getDistance();
	}

	public boolean getTopLimitState() {
		return top.get();
	}

	public boolean getBottomLimitState() {
		return bottom.get();
	}
}
