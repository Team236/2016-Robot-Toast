package frc.team236.stronghold.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team236.pid.PID;
import frc.team236.pid.PIDOutput;
import frc.team236.pid.PIDSource;
import frc.team236.stronghold.RobotMap;
import frc.team236.ticktock.Ticker;

public class Arm extends Subsystem implements PIDSource, PIDOutput {

	private SpeedController motor;
	public Encoder encoder;
	private DigitalInput top, bottom;
	public PID controller;
	public Ticker pidTicker;

	public Arm() {
		motor = new Talon(RobotMap.Arm.PWM_MOTOR);
		motor.setInverted(RobotMap.Arm.INV_MOTOR);

		encoder = new Encoder(RobotMap.Arm.DIO_ENCODER_A, RobotMap.Arm.DIO_ENCODER_B);
		encoder.setDistancePerPulse(RobotMap.Arm.DISTANCE_PER_PULSE);

		top = new DigitalInput(RobotMap.Arm.DIO_LIMIT_TOP);
		bottom = new DigitalInput(RobotMap.Arm.DIO_LIMIT_BOTTOM);

		controller = new PID(this, this, RobotMap.Arm.GAINS);
		pidTicker = new Ticker(controller, RobotMap.Arm.GAINS.interval);
	}

	@Override
	protected void initDefaultCommand() {

	}

	@Override
	public void setSpeed(double speed) {
		if (top.get() && speed > 0) {
			speed = 0;
		} else if (bottom.get() && speed < 0) {
			speed = 0;
		}
		motor.set(speed);
	}

	public void stop() {
		this.setSpeed(0);
	}

	public double getRawEncoder() {
		return encoder.getRaw();
	}

	public void zeroEncoder() {
		encoder.reset();
	}

	public double getAngle() {
		return encoder.getDistance();
	}

	public boolean getTopLimitState() {
		return top.get();
	}

	public boolean getBottomLimitState() {
		return bottom.get();
	}

	@Override
	public double getPos() {
		return getRawEncoder();
	}
}
