// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//* Neccesary imports */
package frc.robot.assessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  //* Declares the variables */
  private final TalonFX angleMotor;
  private final TalonFX revMotorOne;
  private final TalonFX revMotorTwo;
  //* Constructor for the Subsystem */
  public ShooterSubsystem() {
    this.angleMotor = new TalonFX(0);
    this.revMotorOne = new TalonFX(1);
    this.revMotorTwo = new TalonFX(2);
  }
  //* Sets motors to coast mode */
  public void coast(){
    angleMotor.setNeutralMode(NeutralModeValue.Coast);
    revMotorOne.setNeutralMode(NeutralModeValue.Coast);
    revMotorTwo.setNeutralMode(NeutralModeValue.Coast);
  }
  //* Brakes the motors */
  public void brake(){
    angleMotor.setNeutralMode(NeutralModeValue.Brake);
    revMotorOne.setNeutralMode(NeutralModeValue.Brake);
    revMotorTwo.setNeutralMode(NeutralModeValue.Brake);
  }
  //* sets the power to the motors */
  public void setPower(double angleSpeed, double motorSpeed){
      angleMotor.set(angleSpeed);
      revMotorOne.set(motorSpeed);
      revMotorTwo.set(motorSpeed);

  }
  //* Sends info to the user about motor voltage */
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Angle Motor Voltage", angleMotor.getMotorVoltage().getValue();
    SmartDashboard.putNumber("Rev Motor1 Voltage", revMotorOne.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Rev Motor2 Voltage", revMotorTwo.getMotorVoltage().getValue());
    // This method will be called once per scheduler run
  }
}
