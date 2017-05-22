package org.usfirst.frc2906.SpanawayLakeSentinels.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class PIDArm extends PIDSubsystem {

	// Initialize your subsystem here

	private final Talon motor;
	private final AnalogPotentiometer pot;
	private String name;

	// Initialize your subsystem here
	public PIDArm(int motorPort, int potPort, String name) {
		super(name, 10.0, 0.0, 40.0);
		this.name = name;
		motor = new Talon(motorPort);
		pot = new AnalogPotentiometer(potPort, 1.0, 0.0);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		getPIDController().setSetpoint(0);
		getPIDController().enable();

		LiveWindow.addActuator(this.name, "motor", motor);
		LiveWindow.addSensor(this.name, "pot", pot);
		LiveWindow.addActuator(this.name, "PIDSubsystem Controller", getPIDController());

	}

	public void initDefaultCommand() {
	}

	@Override
	public boolean onTarget() {
		double e = Math.abs(getPIDController().getError());
		System.out.println(name + ", " + e);
		return e < .15;
	}

	protected double returnPIDInput() {
		return pot.get();
	}

	protected void usePIDOutput(double output) {
		if (!Double.isNaN(output)) {
			motor.pidWrite(output);
		}
	}
}

