package frc.team236.stronghold;

import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team236.stronghold.subsystems.Arm;
import frc.team236.stronghold.subsystems.Climber;
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
	public static Climber climber;

	public static OI oi = new OI();

	@Override
	public String getModuleName() {
		return "2016-Robot-Toast";
	}

	@Override
	public String getModuleVersion() {
		return "1.2.6";
	}

	@Override
	public void robotInit() {
		logger = new Logger("2016-Robot-Toast", Logger.ATTR_DEFAULT);

		driveConfig = buildSettings();

		// Build subsystems
		tank = new TickTank(driveConfig);
		arm = new Arm();
		shooter = new Shooter();
		intake = new Intake();
		climber = new Climber();
	}

	private Settings buildSettings() {
		// Build tank drive
		driveConfig = new Settings();

		// Add sticks
		driveConfig.leftStick = oi.leftStick;
		driveConfig.rightStick = oi.rightStick;

		// Add encoder ports
		driveConfig.leftEncoderA = RobotMap.Drive.DIO_ENCODER_LEFT_A;
		driveConfig.leftEncoderB = RobotMap.Drive.DIO_ENCODER_LEFT_B;
		driveConfig.rightEncoderA = RobotMap.Drive.DIO_ENCODER_RIGHT_A;
		driveConfig.rightEncoderB = RobotMap.Drive.DIO_ENCODER_RIGHT_B;

		// Shifters
		driveConfig.solForward = RobotMap.Drive.SOL_FORWARD;
		driveConfig.solReverse = RobotMap.Drive.SOL_REVERSE;

		// Invert motors
		driveConfig.leftInv = RobotMap.Drive.INV_LEFT_MOTORS;
		driveConfig.rightInv = RobotMap.Drive.INV_RIGHT_MOTORS;

		// Invert encoders
		driveConfig.leftInvEncoder = RobotMap.Drive.INV_LEFT_ENCODER;
		driveConfig.rightInvEncoder = RobotMap.Drive.INV_RIGHT_ENCODER;

		// Miscellaneous
		driveConfig.motorCount = RobotMap.Drive.MOTOR_COUNT;
		driveConfig.controllerType = ControllerType.VICTORSP;
		driveConfig.hasGyro = true;
		driveConfig.dpp = RobotMap.Drive.DISTANCE_PER_PULSE;

		return driveConfig;
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
