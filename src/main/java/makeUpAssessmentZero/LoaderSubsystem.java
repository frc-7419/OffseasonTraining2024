// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package makeUpAssessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {
  /** Creates a new LoaderSubsystem. */
  public final TalonFX loadermotor0;
  public final TalonFX loadermotor1;
  private final double speed;
  public LoaderSubsystem(double speed) {
    this.loadermotor0 = new TalonFX(0);
    this.loadermotor1 = new TalonFX(1);
    this.speed = speed;


  }
  public void CoastLoader(){
    loadermotor0.setNeutralMode(NeutralModeValue.Coast);
    loadermotor1.setNeutralMode(NeutralModeValue.Coast);

  }

  public void BrakeLoader(){
    loadermotor0.setNeutralMode(NeutralModeValue.Brake);
    loadermotor1.setNeutralMode(NeutralModeValue.Brake);
  }

  public void RunLoader(){
    loadermotor0.set(speed);
    loadermotor1.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
