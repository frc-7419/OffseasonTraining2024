// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterWristSubsystem extends SubsystemBase {
  private final TalonFX wristMotor;
  public ShooterWristSubsystem() {
    this.wristMotor = new TalonFX(0);
  }

  public void coast() {
    wristMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake() {
    wristMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void moveWrist(double power) {
    wristMotor.set(power);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter wrist motor volatage", wristMotor.getMotorVoltage().getValue());
  }
}
