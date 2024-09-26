// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.makeupAssessmentSol;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  
  private final TalonFX topIntakeMotor;
  private final TalonFX bottomIntakeMotor;

  public IntakeSubsystem() {
    this.topIntakeMotor = new TalonFX(0);
    this.bottomIntakeMotor = new TalonFX(0);
  }

  public void coast() {
    topIntakeMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomIntakeMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    topIntakeMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomIntakeMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void runIntake(double power) {
    topIntakeMotor.set(power);
    bottomIntakeMotor.set(power);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Top Intake Motor Voltage", topIntakeMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Bottom Intake Motor Voltage", bottomIntakeMotor.getMotorVoltage().getValue());
  }
}
