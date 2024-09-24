// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assesmentZeroRetakeGraded;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.Power;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BrehSubsystem extends SubsystemBase {
  /** Creates a new BrehSubsystem. */
  private TalonFX shooterTop;
  private TalonFX shooterBot;
  private TalonFX intakeTop;
  private TalonFX intakeBot;
  private double power;

  public BrehSubsystem(double power) {
    this.shooterBot = new TalonFX(1);
    this.shooterTop = new TalonFX(14);
    this.intakeBot = new TalonFX(13);
    this.intakeTop = new TalonFX(12);
    this.power = power;
  }
   public void setPower() {
    shooterTop.setPower(power);
    shooterBot.setPower(power);
    intakeTop.setPower(power);
    intakeBot.setPower(power);
    //whoops i aciddentally put setPower instead of set my bad
  }
  public void coastTheMotor() {
    shooterTop.setNeutralMode(NeutralModeValue.Coast);
    shooterBot.setNeutralMode(NeutralModeValue.Coast);
    intakeTop.setNeutralMode(NeutralModeValue.Coast);
    intakeBot.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brakeTheMotor() {
    shooterTop.setNeutralMode(NeutralModeValue.Brake);
    shooterBot.setNeutralMode(NeutralModeValue.Brake);
    intakeTop.setNeutralMode(NeutralModeValue.Brake);
    intakeBot.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("ShooterTop", shooterTop.getMotorVoltage().getValue());
    SmartDashboard.putNumber("ShooterBot", shooterBot.getMotorVoltage().getValue());
    SmartDashboard.putNumber("IntakeTop", intakeBot.getMotorVoltage().getValue());
    SmartDashboard.putNumber("IntakeBot", intakeTop.getMotorVoltage().getValue());
  }
}
