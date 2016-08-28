package frc.team236.stronghold.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team236.stronghold.RobotMap;

public class Shooter extends Subsystem {

	private Spark motor;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public Shooter() {
		motor = new Spark(RobotMap.Shooter.PWM_MOTOR);
	}

	public void setSpeed(double speed) {
		motor.set(speed);
	}
}
