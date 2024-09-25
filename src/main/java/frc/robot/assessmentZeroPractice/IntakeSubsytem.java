// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZeroPractice;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsytem extends SubsystemBase {
  private final TalonFX intakeMotorOne;
  private final TalonFX intakeMotorTwo;
  public IntakeSubsytem() {
    this.intakeMotorOne = new TalonFX(0);
    this.intakeMotorTwo = new TalonFX(1);
  }
  public void setSpeed(double speed){
    intakeMotorOne.set(speed);
    intakeMotorTwo.set(speed);
  }
  public void brake(){
    intakeMotorOne.setNeutralMode(NeutralModeValue.Brake);
    intakeMotorTwo.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coast(){
    intakeMotorOne.setNeutralMode(NeutralModeValue.Coast);
    intakeMotorTwo.setNeutralMode(NeutralModeValue.Coast);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Intake Motor One Voltage", intakeMotorOne.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Intake Motor Two Voltage", intakeMotorTwo.getMotorVoltage().getValue());
  }
}
