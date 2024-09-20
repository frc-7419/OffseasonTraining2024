// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.AssessmentZero;

import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

  private TalonFX shooterMotor;
  private TalonFX wheelMotor1;
  private TalonFX wheelMotor2;
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem(TalonFX shooterMotor, TalonFX wheelMotor1, TalonFX wheelMotor2) {
    this.shooterMotor = shooterMotor;
    this.wheelMotor1 = wheelMotor1;
    this.wheelMotor2 = wheelMotor2;
  }

  public void setAngle(double power) {
      shooterMotor.set(power);
  }
  public void setPowerWheelMotor(double power) {
      wheelMotor1.set(power);
      wheelMotor2.set(power);
  }

  public void stopMotor() {
      wheelMotor1.set(0);
      wheelMotor2.set(0);
  }
  public void coast() {
    wheelMotor1.setNeutralMode(NeutralModeValue.Coast);
    wheelMotor2.setNeutralMode(NeutralModeValue.Coast);
    shooterMotor.setNeutralMode(NeutralModeValue.Coast);
  
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
