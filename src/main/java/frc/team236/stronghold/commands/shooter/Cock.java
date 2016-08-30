package frc.team236.stronghold.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team236.stronghold.RobotModule;

/**
 *
 */
public class Cock extends Command {
	private int i;

	public Cock() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(RobotModule.shooter);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		i = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		RobotModule.shooter.setSpeed(.6); // Retract spring
		if (i > 10) {
			RobotModule.shooter.insertPin();
		}
		i++;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (i / 50) > 5; // Time out after 5 seconds
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotModule.shooter.stop();
		RobotModule.shooter.setIsCocked(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
