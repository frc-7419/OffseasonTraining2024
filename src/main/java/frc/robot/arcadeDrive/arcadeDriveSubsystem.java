// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.arcadeDrive;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class arcadeDriveSubsystem extends SubsystemBase {
  /** Creates a new arcadeDriveSubsystem. */
  private final TalonFX motorRF;
  private final TalonFX motorRB;
  private final TalonFX motorLF;
  private final TalonFX motorLB;
  public arcadeDriveSubsystem() {
    this.motorRF = new TalonFX(0);
    this.motorRB = new TalonFX(1);
    this.motorLF = new TalonFX(2);
    this.motorLB = new TalonFX(3);
  }

  public void coast(){
    motorRF.setNeutralMode(NeutralModeValue.Coast);
    motorRB.setNeutralMode(NeutralModeValue.Coast);
    motorLF.setNeutralMode(NeutralModeValue.Coast);
    motorLB.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake(){
    motorRF.setNeutralMode(NeutralModeValue.Brake);
    motorRB.setNeutralMode(NeutralModeValue.Brake);
    motorLF.setNeutralMode(NeutralModeValue.Brake);
    motorLB.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setPower(double leftPower, double rightPower){
    motorRF.set(rightPower);
    motorRB.set(rightPower);
    motorLF.set(leftPower);
    motorLB.set(leftPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
