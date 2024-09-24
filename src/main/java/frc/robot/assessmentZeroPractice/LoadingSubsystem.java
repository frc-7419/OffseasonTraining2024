// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZeroPractice;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoadingSubsystem extends SubsystemBase {
  private final TalonFX loadingMotorOne;
  private final TalonFX loadingMotorTwo;
  public LoadingSubsystem() {
    this.loadingMotorOne = new TalonFX(0);
    this.loadingMotorTwo = new TalonFX(1);
  }
  public void setSpeed(double speed){
    loadingMotorOne.set(speed);
    loadingMotorTwo.set(speed);
  }
   public void brake(){
    loadingMotorOne.setNeutralMode(NeutralModeValue.Brake);
    loadingMotorTwo.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coast(){
    loadingMotorOne.setNeutralMode(NeutralModeValue.Coast);
    loadingMotorTwo.setNeutralMode(NeutralModeValue.Coast);
  }
  @Override
  public void periodic() {
     SmartDashboard.putNumber("Loading Motor One Voltage", loadingMotorOne.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Loading Motor Two Voltage", loadingMotorTwo.getMotorVoltage().getValue());
  }
}
