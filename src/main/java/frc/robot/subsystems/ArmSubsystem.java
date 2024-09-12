// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private TalonFX armMotor;

  public ArmSubsystem(TalonFX armMotor) {
      this.armMotor = armMotor;

  }

  
  public void brake() {
    armMotor.setNeutralMode(NeutralModeValue.Brake);
    
  }
  public void setPower(double power) {
    armMotor.set(power);
  }
  
  public void coast () {
    armMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
