package frc.team236.stronghold;

import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team236.stronghold.subsystems.Arm;
import frc.team236.stronghold.subsystems.Intake;
import frc.team236.stronghold.subsystems.Shooter;
import frc.team236.ticktank.ControllerType;
import frc.team236.ticktank.Settings;
import frc.team236.ticktank.TickTank;
import jaci.openrio.toast.lib.log.Logger;
import jaci.openrio.toast.lib.module.IterativeModule;

public class RobotModule extends IterativeModule {

	public static Logger logger;

	public static Settings driveConfig;
	public static TickTank tank;
	public static Arm arm;
	public static Shooter shooter;
	public static Intake intake;

	public static OI oi = new OI();

	@Override
	public String getModuleName() {
		return "2016-Robot-Toast";
	}

	@Override
	public String getModuleVersion() {
		return "1.1.4";
	}

	@Override
	public void robotInit() {
		logger = new Logger("2016-Robot-Toast", Logger.ATTR_DEFAULT);

		// Build tank drive
		driveConfig = new Settings();
		driveConfig.setLeftStick(oi.leftStick);
		driveConfig.setRightStick(oi.rightStick);
		driveConfig.setCount(RobotMap.Drive.MOTOR_COUNT);
		driveConfig.setControllerType(ControllerType.VICTORSP);
		try {
			driveConfig.setLeftEncoderPort(RobotMap.Drive.DIO_ENCODER_LEFT_A, RobotMap.Drive.DIO_ENCODER_LEFT_B);
			driveConfig.setRightEncoderPort(RobotMap.Drive.DIO_ENCODER_RIGHT_A, RobotMap.Drive.DIO_ENCODER_RIGHT_B);
			tank = new TickTank(driveConfig);
		} catch (UnsatisfiedLinkError e) {
			logger.warn("No encoders will be used in simulation");
			driveConfig.hasEncoders = false;
		}
		tank = new TickTank(driveConfig);
		arm = new Arm();
		shooter = new Shooter();
		intake = new Intake();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {

	}

	@Override
	public void teleopInit() {

	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
