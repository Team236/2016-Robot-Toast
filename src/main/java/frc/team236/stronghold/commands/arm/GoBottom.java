package frc.team236.stronghold.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.team236.stronghold.RobotMap;
import frc.team236.stronghold.RobotModule;

/**
 *
 */
public class GoBottom extends Command {

	public GoBottom() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(RobotModule.arm);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		RobotModule.arm.pidTicker.start();
		RobotModule.arm.controller.setSetpoint(RobotMap.Arm.BOTTOM_RAW);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return RobotModule.arm.getBottomLimitState();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotModule.arm.pidTicker.stop();
		RobotModule.arm.stop();
		RobotModule.arm.zeroEncoder();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
