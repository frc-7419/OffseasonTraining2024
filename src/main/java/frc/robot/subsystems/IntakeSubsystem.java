// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private final CANSparkMax leftIntakeMotor;
  private final CANSparkMax rightIntakeMotor;
  public IntakeSubsystem() {
    this.leftIntakeMotor = new CANSparkMax(0, MotorType.kBrushless);
    this.rightIntakeMotor = new CANSparkMax(1, MotorType.kBrushless);

  }

  public void brake() {
    rightIntakeMotor.setIdleMode(IdleMode.kBrake);
    leftIntakeMotor.setIdleMode(IdleMode.kBrake);
  }

   public void coast() {
    rightIntakeMotor.setIdleMode(IdleMode.kCoast);
    leftIntakeMotor.setIdleMode(IdleMode.kCoast);
  }

  public void setVoltage(double power) {
    rightIntakeMotor.setVoltage(power);
    leftIntakeMotor.setVoltage(power);
  }
  public void set(double speed) {
    rightIntakeMotor.set(speed);
    leftIntakeMotor.set(speed);
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Voltage of the left intake motor is", + leftIntakeMotor.getAppliedOutput());
    SmartDashboard.putNumber("Voltage of the right intake motor is", + rightIntakeMotor.getAppliedOutput());
  }
}
