package frc.team236.stronghold.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.team236.stronghold.ControlMap;
import frc.team236.stronghold.RobotModule;

/**
 *
 */
public class ArmWithJoystick extends Command {
	private final double scaleFactorUp = 1.5;
	private final double scaleFactorDown = 4;
	private final int axis = ControlMap.Controller.AXIS_ARM;

	public ArmWithJoystick() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(RobotModule.arm);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		RobotModule.arm.pidTicker.stop();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double joySpeed = -RobotModule.oi.controller.getRawAxis(axis);

		if (joySpeed / joySpeed == 1) {
			// Arm is going up
			RobotModule.arm.setSpeed(joySpeed / scaleFactorUp);
		} else {
			// Arm is going down
			RobotModule.arm.setSpeed(joySpeed / scaleFactorDown);
		}

		if (RobotModule.arm.getBottomLimitState()) {
			RobotModule.arm.zeroEncoder();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// Keep arm at this angle
		RobotModule.arm.controller.setSetpoint(RobotModule.arm.getRawEncoder());
		RobotModule.arm.pidTicker.start();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
