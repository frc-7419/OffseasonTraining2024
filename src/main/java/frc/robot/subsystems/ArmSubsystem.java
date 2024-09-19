// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ArmSubsystem extends SubsystemBase {

  private TalonFX armMotor;

  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
    this.armMotor = new TalonFX(0);
  }


  public void coast() {
    // Set the arm to coast mode
    armMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    // Set the arm to brake mode
    armMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setPower(double power) {
    // Set the power of the arm motor
    armMotor.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
