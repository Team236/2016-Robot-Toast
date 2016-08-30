package frc.team236.stronghold.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team236.stronghold.RobotModule;

public class Stop extends Command {

	@Override
	protected void initialize() {
		requires(RobotModule.tank);
		requires(RobotModule.arm);
		requires(RobotModule.shooter);
		requires(RobotModule.intake);

		RobotModule.tank.stop();
		RobotModule.arm.stop();
		RobotModule.shooter.stop();
		RobotModule.intake.stop();
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
