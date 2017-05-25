package org.usfirst.frc2906.SpanawayLakeSentinels.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RaiseArm extends CommandGroup {

    public RaiseArm() {
        addSequential(new SetArmSetpoint(-25));
    }
}
