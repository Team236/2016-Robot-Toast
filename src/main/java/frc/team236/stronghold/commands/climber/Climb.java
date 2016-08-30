package frc.team236.stronghold.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.team236.stronghold.RobotModule;

/**
 *
 */
public class Climb extends Command {

	public Climb() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(RobotModule.climber);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		RobotModule.climber.setSpeed(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotModule.climber.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
