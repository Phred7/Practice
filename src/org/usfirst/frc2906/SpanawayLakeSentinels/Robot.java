// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2906.SpanawayLakeSentinels;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2906.SpanawayLakeSentinels.commands.*;
import org.usfirst.frc2906.SpanawayLakeSentinels.subsystems.*;

import org.usfirst.frc2906.SpanawayLakeSentinels.RobotMap.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    Command AutoNone;
    Command AutoTestSendableMovement;
    Command AutoDrive;
	//Command AutoEncoderTestI; 
	
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Pneumatics pneumatics;
    public static Wheels wheels; 
    public static armDrive armDrive;
    public static PIDArm PIDArm;
    public static Tracker tracker;
    public static testRelay testRelay;
    public static Pneumatics testSolenoid1;
    public static Pneumatics testSolenoid2;
    public static Encoder encoderRight;
    public static Encoder encoderLeft;
    public static testBenchMotor testBenchMotor;
	public static double maxPeriod = 0.1;
	public static int minRate = 10;
	public static double distanceperPulse = (6.0/* in */ * Math.PI) / (360.0 * 12.0/* in/ft */);
	public static double rpmsperPulse = /**/(Math.PI);
	public static double calculatedDriveGearRatio = ((50/14)*(48/16));
	public static double outputDriveGearRatio = (10.71/1);
	public static int samplestoAverage = 7;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
	
	SendableChooser<Command> auto = new SendableChooser<>();
	
	final String AutoNone1 = "No Auto";
	final String AutoTestSendableMovement1 = "Test Auto Sendable";
	final String AutoDrive1 = "Just drive";
	
	String[] autoList = { AutoNone1, AutoTestSendableMovement1, AutoDrive1};
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        pneumatics = new Pneumatics();
        wheels = new Wheels();
        armDrive = new armDrive();
        PIDArm = new PIDArm(0, 0, AutoDrive1);
        testBenchMotor = new testBenchMotor();
        tracker = new Tracker();
        testRelay = new testRelay();
        testSolenoid1 = new Pneumatics();
        testSolenoid2 = new Pneumatics();
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        encoderRight = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
        encoderRight.setPIDSourceType(PIDSourceType.kDisplacement);
        encoderRight.setDistancePerPulse(distanceperPulse);
        encoderRight.setSamplesToAverage(samplestoAverage);

        
        encoderLeft = new Encoder(4, 5, true, Encoder.EncodingType.k4X);
        encoderLeft.setPIDSourceType(PIDSourceType.kDisplacement);
        encoderLeft.setDistancePerPulse(distanceperPulse);
        encoderLeft.setSamplesToAverage(samplestoAverage);

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        NetworkTable table = NetworkTable.getTable("SmartDashboard");
        table.putStringArray("Auto List", autoList);
        
		auto = new SendableChooser();
		auto.addObject("No Auto", new AutoNone());
		auto.addObject("Test Auto Sendable", new AutoTestSendableMovement());
		auto.addObject("Just drive", new AutoDrive());
		SmartDashboard.putData("Auto Mode", auto);
		
        tracker.setZero();
        
        SmartDashboard.putData(Scheduler.getInstance());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    
    public void disabledInit(){
    	Robot.wheels.ballStop();
    	Robot.armDrive.armStop();
    	Robot.testRelay.spikeOff();
    	
    	
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) auto.getSelected();
    	
        if (autonomousCommand != null) 
        		autonomousCommand.start();
	    
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("encoder value", (RobotMap.encoder.get()));
        SmartDashboard.putNumber("encoder value right", encoderRight.get());
        //SmartDashboard.putInt("encoder value left", encoderLeft.get());
        /*if (Math.abs(RobotMap.encoderLeft.get()) < 500){
        	Robot.driveTrain.arcadeDrive(1, 1);
        	
        }
        else {
        	Robot.driveTrain.arcadeDrive(0, 0);
        }*/
        
        
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("encoder value", (RobotMap.encoder.get()));
        SmartDashboard.putNumber("encoder value right", encoderRight.get());
        SmartDashboard.putNumber("encoder value left",  encoderLeft.get());
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
