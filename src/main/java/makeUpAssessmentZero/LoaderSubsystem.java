// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package makeUpAssessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {
  /** Creates a new LoaderSubsystem. */
  public final TalonFX loaderMotor0;
  public final TalonFX loaderMotor1;
  private final double speed;
  public LoaderSubsystem(double speed) {
    this.loaderMotor0 = new TalonFX(0);
    this.loaderMotor1 = new TalonFX(1);
    this.speed = speed;


  }
  public void CoastLoader(){
    loaderMotor0.setNeutralMode(NeutralModeValue.Coast);
    loaderMotor1.setNeutralMode(NeutralModeValue.Coast);

  }

  public void BrakeLoader(){
    loaderMotor0.setNeutralMode(NeutralModeValue.Brake);
    loaderMotor1.setNeutralMode(NeutralModeValue.Brake);
  }

  public void RunLoader(){
    loaderMotor0.set(speed);
    loaderMotor1.set(speed);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("First Loader Voltage: ", loaderMotor0.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Second Loader Voltage: ", loaderMotor0.getMotorVoltage().getValue());
    // This method will be called once per scheduler run
  }
}
