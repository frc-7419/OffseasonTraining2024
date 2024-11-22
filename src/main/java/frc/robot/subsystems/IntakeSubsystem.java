// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final CANSparkMax leftIntakeMotor;
  private final CANSparkMax rightIntakeMotor;

  public IntakeSubsystem() {//constructor
    //initialize
    this.leftIntakeMotor = new CANSparkMax(0, MotorType.kBrushless);
    this.rightIntakeMotor = new CANSparkMax(0, MotorType.kBrushless);
    invertMotors();
  }

  public void invertMotors() {
    rightIntakeMotor.setInverted(true);
    leftIntakeMotor.setInverted(false);
  }

  public void brake() {
    leftIntakeMotor.setIdleMode(IdleMode.kBrake);
    rightIntakeMotor.setIdleMode(IdleMode.kBrake);
  }

  public void coast() {
    leftIntakeMotor.setIdleMode(IdleMode.kCoast);
    rightIntakeMotor.setIdleMode(IdleMode.kCoast);
  }

  public void setVoltage(double power) {
    leftIntakeMotor.setVoltage(power);
    rightIntakeMotor.setVoltage(power);
  }

  public void setSpeed(double power) {
    leftIntakeMotor.set(power);
    rightIntakeMotor.set(power);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
