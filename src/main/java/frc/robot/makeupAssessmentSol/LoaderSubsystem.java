// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.makeupAssessmentSol;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {

  private final TalonFX topLoaderMotor;
  private final TalonFX bottomLoaderMotor;

  public LoaderSubsystem() {
    this.topLoaderMotor = new TalonFX(0);
    this.bottomLoaderMotor = new TalonFX(0);
  }

  public void coast() {
    topLoaderMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomLoaderMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    topLoaderMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomLoaderMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void runLoader(double power) {
    topLoaderMotor.set(power);
    bottomLoaderMotor.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
