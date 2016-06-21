package frc.team236.stronghold;

import frc.team236.ticktank.TickTank;
import frc.team236.ticktank.Settings;

import jaci.openrio.toast.lib.log.Logger;
import jaci.openrio.toast.lib.module.IterativeModule;

public class RobotModule extends IterativeModule {

    public static Logger logger;

    public static TickTank drive;
    public static Settings driveConfig;

    @Override
    public String getModuleName() {
        return "2016-Robot-Toast";
    }

    @Override
    public String getModuleVersion() {
        return "0.0.1";
    }

    @Override
    public void robotInit() {
        logger = new Logger("2016-Robot-Toast", Logger.ATTR_DEFAULT);

        driveConfig = new Settings();
        //TODO: Module Init
    }
}
