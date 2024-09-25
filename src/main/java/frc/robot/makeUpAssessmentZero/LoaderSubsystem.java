// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.makeUpAssessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {
  private final TalonFX topMotor;
  private final TalonFX bottomMotor;
  public LoaderSubsystem() {
    this.topMotor = new TalonFX(0);
    this.bottomMotor = new TalonFX(0);
  }

  /**
   * Sets both motors to coast mode
   */
  public void coast() {
    topMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  /**
   * Sets both motors to brake mode
   */
  public void brake() {
    topMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  /**
   * Runs the loader at the given power
   * @param power this is in percentage and goes form -1 to 1
   */
  public void runLoader(double power) {
    topMotor.set(power);
    bottomMotor.set(power);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Top loader motor volatage", topMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Bottom loader motor volatage", bottomMotor.getMotorVoltage().getValue());
  }
}
