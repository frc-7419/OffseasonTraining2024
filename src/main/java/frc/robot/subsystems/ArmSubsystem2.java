// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem2 extends SubsystemBase {
  /** Creates a new ArmSubsystem2. */
  private final TalonFX armMotor;
  
  public ArmSubsystem2() {
    this.armMotor = new TalonFX(0); 
  }

  public void coast() {
    armMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake(){
    armMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void runMotor(double power, boolean setInverted){
    armMotor.setInverted(setInverted);
    armMotor.set(power);
  }
  @Override
  public void periodic() {
    // SmartDashboard.putNumber(getName(), )
  }
}
