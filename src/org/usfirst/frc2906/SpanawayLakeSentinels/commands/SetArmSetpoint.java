package org.usfirst.frc2906.SpanawayLakeSentinels.commands;

import org.usfirst.frc2906.SpanawayLakeSentinels.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetArmSetpoint extends Command {
	
	double m_setpoint;

    public SetArmSetpoint(double setpoint) {
    	m_setpoint = setpoint;
        requires(Robot.PIDArm);
        requires(Robot.armDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.PIDArm.enable();
    	Robot.PIDArm.setSetpoint(m_setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.PIDArm.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
