// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assesmentZeroRetakeGraded;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new BrehSubsystem. */
  private TalonFX intakeTop;
  private TalonFX intakeBot;

  public IntakeSubsystem() {
    this.intakeBot = new TalonFX(13);
    this.intakeTop = new TalonFX(12);
  }
   public void setPower(double power) {
    intakeTop.set(power);
    intakeBot.set(power);
  }
  public void coastTheIntakeMotor() {
    intakeTop.setNeutralMode(NeutralModeValue.Coast);
    intakeBot.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brakeTheIntakeMotor() {
    intakeTop.setNeutralMode(NeutralModeValue.Brake);
    intakeBot.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("IntakeBot", intakeBot.getMotorVoltage().getValue());
    SmartDashboard.putNumber("IntakeTop", intakeTop.getMotorVoltage().getValue());
  }
}
