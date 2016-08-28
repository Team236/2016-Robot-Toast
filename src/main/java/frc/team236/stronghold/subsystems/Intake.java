package frc.team236.stronghold.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team236.stronghold.RobotMap;

public class Intake extends Subsystem {

	private SpeedController motor;
	private DigitalInput limit;

	public Intake() {
		motor = new Spark(RobotMap.Intake.PWM_MOTOR);
		limit = new DigitalInput(RobotMap.Intake.DIO_LIMIT);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void setSpeed(double speed) {
		motor.set(speed);
	}

	public boolean getLimitState() {
		return limit.get();
	}

	public void intake() {
		setSpeed(1);
	}

	public void eject() {
		setSpeed(-1);
	}

	public void stop() {
		setSpeed(0);
	}
}
