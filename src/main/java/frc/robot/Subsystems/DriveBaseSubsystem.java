// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.Constants;

public class DriveBaseSubsystem extends SubsystemBase {
  private final TalonFX leftLeaderMotor;
  private final TalonFX leftFollowerMotor;
  private final TalonFX rightLeaderMotor;
  private final TalonFX rightFollowerMotor;

  public DriveBaseSubsystem() {
    leftLeaderMotor = new TalonFX(Constants.CANIds.leftFalcon1.id);
    leftFollowerMotor = new TalonFX(Constants.CANIds.leftFalcon2.id);
    rightLeaderMotor = new TalonFX(Constants.CANIds.rightFalcon1.id);
    rightFollowerMotor = new TalonFX(Constants.CANIds.rightFalcon2.id);

    leftLeaderMotor.setInverted(true);
    leftFollowerMotor.setInverted(true);
    rightLeaderMotor.setInverted(true);
    rightFollowerMotor.setInverted(true);
  }

  public void setPower(double leftPower, double rightPower) {
    leftLeaderMotor.set(ControlMode.PercentOutput, leftPower);
    leftFollowerMotor.set(ControlMode.PercentOutput, leftPower);
    rightLeaderMotor.set(ControlMode.PercentOutput, rightPower);
    rightFollowerMotor.set(ControlMode.PercentOutput, rightPower);
  }

  @Override
  public void periodic() {}
}