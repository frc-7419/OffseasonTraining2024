// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final TalonFX intakeMotorLeft;
  private final TalonFX intakeMotorRight;
  public IntakeSubsystem() {
    this.intakeMotorLeft = new TalonFX(0);
    this.intakeMotorRight = new TalonFX(1);
  }
  public void runIntake(double speed) {
    intakeMotorLeft.set(speed);
    intakeMotorRight.set(speed);
  }
  public void brake(){
    intakeMotorLeft.setNeutralMode(NeutralModeValue.Brake);
    intakeMotorRight.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coast(){
    intakeMotorLeft.setNeutralMode(NeutralModeValue.Coast);
    intakeMotorRight.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Intake Left Motor Voltage", intakeMotorLeft.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Intake Right Motor Voltage", intakeMotorRight.getMotorVoltage().getValue());
  }
}
