// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Assessment0;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {
  TalonFX loader1;
  TalonFX loader2;
  /** Creates a new Intake. */
  public LoaderSubsystem() {
    loader1 = new TalonFX(2);
    loader2 = new TalonFX(3);
    loader2.setInverted(true);
  }

  public void Coast() {
    loader1.setNeutralMode(NeutralModeValue.Coast);
    loader2.setNeutralMode(NeutralModeValue.Coast);
  }

  public void Brake() {
    loader1.setNeutralMode(NeutralModeValue.Brake);
    loader2.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setSpeed(double speed) {
    loader1.set(speed);
    loader2.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Loader Voltage ", loader1.getMotorVoltage().getValue());
  }
}
