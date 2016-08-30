package frc.team236.stronghold.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.team236.stronghold.RobotModule;

/**
 * @param _goal
 *            The angle for the arm to go to.
 */
public class SetArmAngle extends Command {
	private double goal;

	public SetArmAngle(double _goal) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(RobotModule.arm);
		this.goal = _goal;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		RobotModule.arm.controller.setSetpoint(goal);
		RobotModule.arm.pidTicker.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotModule.arm.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
