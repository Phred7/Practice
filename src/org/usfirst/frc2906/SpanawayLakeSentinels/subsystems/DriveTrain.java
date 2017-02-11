// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2906.SpanawayLakeSentinels.subsystems;

import org.usfirst.frc2906.SpanawayLakeSentinels.Robot;
import org.usfirst.frc2906.SpanawayLakeSentinels.RobotMap;
import org.usfirst.frc2906.SpanawayLakeSentinels.commands.*;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class DriveTrain extends Subsystem {


	Encoder encLD = Robot.encoderLeft;
	Encoder encRD = Robot.encoderRight;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS



	


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
   
    private final RobotDrive robotDrive21 = RobotMap.driveTrainRobotDrive21;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void arcadeDrive(double move, double rotate){
    	robotDrive21.arcadeDrive(move, rotate);
    }
    
    public void midStart(){
 	   Robot.driveTrain.arcadeDrive(.1,.8);
 	   Timer.delay(5);
 	   Robot.driveTrain.arcadeDrive(0,0);
    }
    
    public void leftStart(){
 	   Robot.driveTrain.arcadeDrive(0,0);
 	   Timer.delay(20);
 	   Robot.driveTrain.arcadeDrive(0, 0);
    }
    
    public void rightStart(){
 	   Robot.driveTrain.arcadeDrive(0,0);
 	   Timer.delay(20);
 	   Robot.driveTrain.arcadeDrive(0, 0);
    }
    
    public void straightStart(){
 	   Robot.driveTrain.arcadeDrive(0,0);
 	   Timer.delay(20);
 	   Robot.driveTrain.arcadeDrive(0, 0);
    }
    
    public void resetEncs(){
    	Robot.encoderLeft.reset();
    	Robot.encoderRight.reset();
    }
    
    public void resetEncR(){
    	Robot.encoderRight.reset();
    }
    
    public void resetEncL(){
    	Robot.encoderLeft.reset();
    }
    
    public void drive(){
    	Robot.driveTrain.arcadeDrive(.3, .3);
    	
    }
    public boolean dankMemes = false;
    public void runEncs(int encoderValue){

    	
    	//int encLDValue = encLD.get();
    while( Math.abs(Robot.encoderLeft.get())<= 1000){
    		Robot.driveTrain.arcadeDrive(0.5, 0.5);
    		SmartDashboard.putNumber("Encoder Number", Math.abs(Robot.encoderLeft.get()));
    		dankMemes = true;
    		
    	
    	} 


    	
    }
    public void runEncs2(){
    	while(Math.abs(Robot.encoderLeft.get())<= 2000){
    		Robot.driveTrain.arcadeDrive(1.0, 1.0);
    	}
    }
    	

}


