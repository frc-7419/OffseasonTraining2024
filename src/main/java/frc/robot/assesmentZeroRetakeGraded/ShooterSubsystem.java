// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assesmentZeroRetakeGraded;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new BrehSubsystem. */
  private TalonFX shooterTop;
  private TalonFX shooterBot;

  public ShooterSubsystem() {
    this.shooterBot = new TalonFX(1);
    this.shooterTop = new TalonFX(14);
  }
   public void setThePower(double power) {
    shooterTop.set(power);
    shooterBot.set(power);
  }
  public void coastTheMotor() {
    shooterTop.setNeutralMode(NeutralModeValue.Coast);
    shooterBot.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brakeTheMotor() {
    shooterTop.setNeutralMode(NeutralModeValue.Brake);
    shooterBot.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("ShooterTop", shooterTop.getMotorVoltage().getValue());
    SmartDashboard.putNumber("ShooterBot", shooterBot.getMotorVoltage().getValue());
  }
}
