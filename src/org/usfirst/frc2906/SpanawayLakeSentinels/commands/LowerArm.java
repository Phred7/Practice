package org.usfirst.frc2906.SpanawayLakeSentinels.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowerArm extends CommandGroup {

    public LowerArm() {
       addSequential(new SetArmSetpoint(.2));
       addSequential(new WaitCommand(.5));
       addSequential(new SetArmSetpoint(0));
       
    }
}
