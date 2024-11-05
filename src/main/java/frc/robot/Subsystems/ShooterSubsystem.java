// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX shooterMotorLeft;
  private final TalonFX shooterMotorRight;
  public ShooterSubsystem() {
    this.shooterMotorLeft = new TalonFX(0);
    this.shooterMotorRight = new TalonFX(1);
  }
  public void runShooter(double speed) {
    shooterMotorLeft.set(speed);
    shooterMotorRight.set(speed);
  }
  public void brake(){
    shooterMotorLeft.setNeutralMode(NeutralModeValue.Brake);
    shooterMotorRight.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coast(){
    shooterMotorLeft.setNeutralMode(NeutralModeValue.Coast);
    shooterMotorRight.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter Left Motor Voltage", shooterMotorLeft.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Shooter Right Motor Voltage", shooterMotorRight.getMotorVoltage().getValue());
  }
}
