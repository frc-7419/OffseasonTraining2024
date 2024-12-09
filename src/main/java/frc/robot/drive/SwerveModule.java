// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package drive;


import com.ctre.phoenix6.swerve.SwerveModuleConstants;

import java.beans.PersistenceDelegate;
import java.math.RoundingMode;

import com.ctre.phoenix6.hardware.CANcoder;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.kinematics.struct.SwerveModulePositionStruct;
import frc.robot.Constants;
import frc.robot.Constants.Operator.SwerveConstants;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkBase;

public class SwerveModule {
    private final SparkMax turnMotor;
    private final SparkMax driveMotor;
    private final CANcoder turnCoder;
    private final RelativeEncoder driveCoder;
    private final PIDController angleController;
    private final String module;

/**
 * 
 * @param turnMotorId;
 * @param driveMotorId;
 * @param turnEncoderId;
 * @param turnEncoderOffset;
 */


public SwerveModule(int turnMotorId, int driveMotorId, int turnEncoderId, double turnEncoderOffset){
    this.angleController = new PIDController(SwerveConstants.anglekP, SwerveConstants.anglekI, SwerveConstants.anglekD);

    angleController.setTolerance(10.0/360.0);
    this.turnMotor = new SparkMax(turnMotorId, MotorType.kBrushless);
    this.driveMotor = new SparkMax(turnEncoderId, MotorType.kBrushed);
    this.driveCoder = driveMotor.getEncoder();
    this.turnCoder = new CANcoder(turnEncoderId);
    this.module = "";
    angleController.enableContinuousInput(0, 360);
    turnCoder.setPosition(turnEncoderOffset);
    
    //damn bro everything is deprecated
    Rotation2d rotation2d = new Rotation2d();



        }

private void coast(){
    turnMotor.setidleMode(IdleMode.kCoast);
    driveMotor.setIdleMode(IdleMode.kCoast);
}
private void brake(){
    turnMotor.setIdleMode(IdleMode.kBrake);
    driveMotor.setIdleMode(IdleMode.kBrake);
}
private void setVoltage(double power){
    turnMotor.setVoltage(power);
    driveMotor.setVoltage(power);
    

}
private SwerveModuleState getSwerveState(){
    return new SwerveModuleState(driveCoder.getVelocity(), Rotation2d.fromDegrees(turnCoder.getPosition()));
}
private SwerveModulePosition getPosition(){
    return new SwerveModulePosition(driveCoder.getPosition(), Rotation2d.fromDegrees(turnCoder.getPosition()));

}
private void resetDriveEncoder(){
    driveCoder.setPosition(0);

}
private double driveEncoderPosition(){
    return driveCoder.getPosition();
}
private void setState(SwerveModuleState moduleState){
    SwerveModule newModuleState = SwerveModuleState.optimize(moduleState, turnCoder.getAbsolutePosition().getValueAsDouble());//convert this to degrees and or use the unit class
}
    }
