package frc.team236.stronghold.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team236.stronghold.commands.Wait;

public class ShootCycle extends CommandGroup {
    public ShootCycle() {
	addSequential(new Shoot());
	addSequential(new Wait(0.0D));
	addSequential(new Cock());
    }
}
