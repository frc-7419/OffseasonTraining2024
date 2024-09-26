// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZeroSol;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  
  private final TalonFX topMotor;
  private final TalonFX bottomMotor;

  public ShooterSubsystem() {
    this.topMotor = new TalonFX(0);
    this.bottomMotor = new TalonFX(1);
  }

  public void coast() {
    topMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    topMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void runShooter(double power) {
    topMotor.set(power);
    bottomMotor.set(power);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Top Shooter Motor Voltage", topMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Bottom Shooter Motor Voltage", bottomMotor.getMotorVoltage().getValue());
  }
}
