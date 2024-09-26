// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZeroPractice;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final TalonFX intakeMotorOne;
  private final TalonFX intakeMotorTwo;
  /** Creates a new intakeSubsystem. */
  public IntakeSubsystem() {
    this.intakeMotorOne = new TalosnFX(0);
    this.intakeMotorTwo = new TalonFX(1);
  }
  public void coast(){
    intakeMotorOne.setNeutralMode(NeutralModeValue.Coast);
    intakeMotorTwo.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake(){
    intakeMotorOne.setNeutralMode(NeutralModeValue.Brake);
    intakeMotorTwo.setNeutralMode(NeutralModeValue.Brake);

  }

  public void setPower(double powerToIntake){
    intakeMotorOne.set(powerToIntake);
    intakeMotorTwo.set(powerToIntake);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Intake Motor One Voltage", intakeMotorOne.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Intake Motor Two Voltage", intakeMotorTwo.getMotorVoltage().getValue());
  }
}
