// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX armMotor;
  private final DutyCycleEncoder armEncoder;

  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
    this.armMotor = new TalonFX(0);
    this.armEncoder = new DutyCycleEncoder(5); 
  }

  public void setVoltage(double power) {
    armMotor.set(power);
  }

  public void coast() {
    armMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    armMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public double getPosition() {
    return armEncoder.getAbsolutePosition();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Arm motor voltage", armMotor.getMotorVoltage().getValue());
    // This method will be called once per scheduler run
  }
}

