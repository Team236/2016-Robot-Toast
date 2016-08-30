package frc.team236.stronghold.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team236.stronghold.RobotModule;

/**
 *
 */
public class Shoot extends Command {
	private int i;
	private boolean isLimitWorking;

	public Shoot() {
		// Use requires() here to declare subsystem dependencies
		requires(RobotModule.shooter);
		// If the limit switch is depressed when we call the command, then the
		// switch is a valid way to determine if the ball is still in the RobotModule
		isLimitWorking = RobotModule.intake.getLimitState();
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		i = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		RobotModule.shooter.retractPin();
		RobotModule.shooter.setIsCocked(false);
		i++;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (isLimitWorking) {
			// If the limit switch is a valid way to determine if the ball is
			// in the bot, then we can stop the command when the limit switch
			// is no longer pressed.
			return !RobotModule.intake.getLimitState();
		}
		return (i / 50) > 1; // Time out after 1 second
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
