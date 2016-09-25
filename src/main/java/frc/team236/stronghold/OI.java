package frc.team236.stronghold;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team236.stronghold.commands.arm.ArmWithJoystick;
import frc.team236.stronghold.commands.arm.GoBottom;
import frc.team236.stronghold.commands.climber.Climb;
import frc.team236.stronghold.commands.intake.Eject;
import frc.team236.stronghold.commands.intake.Intake;
import frc.team236.stronghold.commands.intake.IntakeOverride;
import frc.team236.stronghold.commands.shooter.Cock;
import frc.team236.stronghold.commands.shooter.ShootCycle;
import frc.team236.ticktank.commands.DriveWithJoysticks;
import frc.team236.ticktank.commands.ShiftUp;
import frc.team236.ticktank.commands.ShiftDown;

public class OI {
	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick controller;

	public Button shiftUp;
	public Button shiftDown;
	public Button intake;
	public Button eject;
	public Button shoot;
	public Button cock;
	public Button armWithJoystick;
	public Button goBottom;
	/*
	public Button goNearBatterHighShotAngle;
	public Button goDefenseHighShotAngle;
	public Button goFarBatterHighShotAngle;
	*/
	public Button controllerShoot;
	public Button controllerIntake;
	public Button intakeOverride;
	public Button climb;
	public Button fixDrive;

	public OI() {
		leftStick = new Joystick(ControlMap.PORT_STICK_LEFT);
		rightStick = new Joystick(ControlMap.PORT_STICK_RIGHT);
		controller = new Joystick(ControlMap.PORT_CONTROLLER);

		// Left Stick
		eject = new JoystickButton(leftStick, ControlMap.LeftStick.EJECT);
		eject.whileHeld(new Eject());

		intake = new JoystickButton(leftStick, ControlMap.LeftStick.INTAKE);
		intake.whileHeld(new Intake());

		cock = new JoystickButton(leftStick, ControlMap.LeftStick.COCK);
		cock.whenPressed(new Cock());

		intakeOverride = new JoystickButton(leftStick, ControlMap.LeftStick.INTAKE_OVERRIDE);
		intakeOverride.whileHeld(new IntakeOverride());

		// Right Stick
		shiftUp = new JoystickButton(rightStick, ControlMap.RightStick.SHIFT_UP);
		shiftUp.whenPressed(new ShiftUp(RobotModule.tank));

		shiftDown = new JoystickButton(rightStick, ControlMap.RightStick.SHIFT_DOWN);
		shiftDown.whenPressed(new ShiftDown(RobotModule.tank));


		// Controller
		armWithJoystick = new JoystickButton(controller, ControlMap.Controller.ENABLE_JOYSTICK);
		armWithJoystick.whileHeld(new ArmWithJoystick());

		shoot = new JoystickButton(controller, ControlMap.Controller.SHOOT);
		shoot.whenPressed(new ShootCycle());

		climb = new JoystickButton(controller, ControlMap.Controller.CLIMB);
		climb.whileHeld(new Climb());

		goBottom = new JoystickButton(controller, ControlMap.Controller.ARM_BOTTOM);
		goBottom.whileHeld(new GoBottom());

		fixDrive = new JoystickButton(controller, ControlMap.Controller.FIX_DRIVE);
		fixDrive.whenPressed(new DriveWithJoysticks(RobotModule.tank));
	}
}
