// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArcadeDrive extends SubsystemBase {
  private final TalonFX leftLeader;
  private final TalonFX rightLeader;
  private final TalonFX leftBack;
  private final TalonFX rightBack;
  public ArcadeDrive() {
    leftLeader = new TalonFX(0);
    rightLeader = new TalonFX(1);
    leftBack = new TalonFX(2);
    rightBack = new TalonFX(3);
  }
  public void setLeftRightPower(double leftPower, double rightPower){
    leftBack.set(leftPower);
    leftLeader.set(leftPower);
    rightLeader.set(rightPower);
    rightBack.set(rightPower);
  }
  public void coast(){
    leftBack.setNeutralMode(NeutralModeValue.Coast);
    leftLeader.setNeutralMode(NeutralModeValue.Coast);
    rightLeader.setNeutralMode(NeutralModeValue.Coast);
    rightBack.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake(){
    leftBack.setNeutralMode(NeutralModeValue.Brake);
    leftLeader.setNeutralMode(NeutralModeValue.Brake);
    rightLeader.setNeutralMode(NeutralModeValue.Brake);
    rightBack.setNeutralMode(NeutralModeValue.Brake);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
