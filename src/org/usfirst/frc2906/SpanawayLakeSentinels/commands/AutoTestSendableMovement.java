package org.usfirst.frc2906.SpanawayLakeSentinels.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoTestSendableMovement extends CommandGroup {

    public AutoTestSendableMovement() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new WaitCommand(.75));
    	addSequential(new Fire());
    	addSequential(new WaitCommand(.5));
    	addSequential(new drive(.3));
    	addSequential(new WaitCommand(.25));
    	addSequential(new driveStop());
    	addSequential(new WaitCommand(.5));
    	addSequential(new Reload());
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
