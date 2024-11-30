// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.AssessmentOnePractice.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
//setMotors do not do the drive function right here
/** Add your docs here. */
public class DriveBaseSubsystem {
    private final TalonFX leftFrontmotor;
    private final TalonFX leftBackmotor;
    private final TalonFX rightFrontmotor;
    private final TalonFX rightBackmotor;
    
    public DriveBaseSubsystem(){
        this.leftFrontmotor = new TalonFX(0);
        this.leftBackmotor = new TalonFX(1);
        this.rightFrontmotor = new TalonFX(2);
        this.rightBackmotor = new TalonFX(3);
    }

    public void runMotor(double rightPower, double leftPower){
        leftFrontmotor.set(leftPower);
        leftBackmotor.set(leftPower);
        rightFrontmotor.set(rightPower);
        leftFrontmotor.set(rightPower);

    }
    public void coast(){
        leftFrontmotor.setNeutralMode(NeutralModeValue.Coast);
        leftBackmotor.setNeutralMode(NeutralModeValue.Coast);
        rightFrontmotor.setNeutralMode(NeutralModeValue.Coast);
        leftFrontmotor.setNeutralMode(NeutralModeValue.Coast);

    }
    public void brake(){
        leftFrontmotor.setNeutralMode(NeutralModeValue.Brake);
        leftBackmotor.setNeutralMode(NeutralModeValue.Brake);
        rightFrontmotor.setNeutralMode(NeutralModeValue.Brake);
        leftFrontmotor.setNeutralMode(NeutralModeValue.Brake);

    }
    
    
}
