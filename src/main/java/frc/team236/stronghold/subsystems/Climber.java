package frc.team236.stronghold.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team236.stronghold.RobotMap;

public class Climber extends Subsystem {

	private SpeedController motor;

	public Climber() {
		motor = new Talon(RobotMap.Climber.PWM_MOTOR);
		motor.setInverted(RobotMap.Climber.INV_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {

	}

	public void setSpeed(double speed) {
		if (speed >= 0) {
			motor.set(speed);
		}
	}
}
