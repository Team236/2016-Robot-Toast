package frc.team236.stronghold.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team236.stronghold.RobotModule;

public class IntakeOverride extends Command {

	@Override
	protected void initialize() {
		requires(RobotModule.intake);

	}

	@Override
	protected void execute() {
		RobotModule.intake.intake();

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotModule.intake.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
