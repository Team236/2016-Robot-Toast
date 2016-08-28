package frc.team236.stronghold.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team236.stronghold.RobotMap;

public class Shooter extends Subsystem {

	private SpeedController motor;
	private DoubleSolenoid sol;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public Shooter() {
		motor = new Spark(RobotMap.Shooter.PWM_MOTOR);
		sol = new DoubleSolenoid(RobotMap.Shooter.SOL_FORWARD, RobotMap.Shooter.SOL_REVERSE);
	}

	public void setSpeed(double speed) {
		motor.set(speed);
	}

	public void stop() {
		setSpeed(0);
	}

	public void retract() {
		setSpeed(-1);
	}

	private void setSol(int direction) {
		switch (direction) {
		case 1:
			sol.set(DoubleSolenoid.Value.kForward);
			break;
		case -1:
			sol.set(DoubleSolenoid.Value.kReverse);
			break;
		default:
			sol.set(DoubleSolenoid.Value.kOff);
			break;
		}
	}

	public void insertPin() {
		setSol(1);
	}

	public void retractPin() {
		setSol(-1);
	}
}
