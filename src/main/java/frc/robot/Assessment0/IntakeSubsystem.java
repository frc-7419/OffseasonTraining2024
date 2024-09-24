// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Assessment0;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  TalonFX intake1;
  TalonFX intake2;
  /** Creates a new Intake. */
  public IntakeSubsystem() {
    intake1 = new TalonFX(0);
    intake2 = new TalonFX(1);
    intake2.setInverted(true);
  }

  public void Coast() {
    intake1.setNeutralMode(NeutralModeValue.Coast);
    intake2.setNeutralMode(NeutralModeValue.Coast);
  }

  public void Brake() {
    intake1.setNeutralMode(NeutralModeValue.Brake);
    intake2.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setSpeed(double speed) {
    intake1.set(speed);
    intake2.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Intake Voltage ", intake1.getMotorVoltage().getValue());
  }
}
