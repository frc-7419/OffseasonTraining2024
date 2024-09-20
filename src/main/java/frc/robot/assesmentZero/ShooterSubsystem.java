// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assesmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstant;
import frc.robot.Constants.ShooterConstant.BottomShooterConstant;
import frc.robot.Constants.ShooterConstant.BottomShooterConstant.TopShooterConstant;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private TalonFX shooterMotor;
  private TalonFX topMotor;
  private TalonFX bottomMotor;
  public final double power;
  //forgot to set in paramater for power
  public ShooterSubsystem(double power) {
    this.shooterMotor = new TalonFX(ShooterConstant.shooterMotorCANID);
    this.topMotor = new TalonFX(TopShooterConstant.topMotorCANID);
    this.bottomMotor = new TalonFX(BottomShooterConstant.bottomMotorCANID);
    this.power = power;
  }
  // forgot the parenthesis
  public void setPower() {
    shooterMotor.setPower(power);
    topMotor.setPower(power);
    bottomMotor.setPower(power);
  }
  public void brakeMotor() {
    shooterMotor.setNeutralMode(NeutralModeValue.Brake);
    topMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coastMotor() {
    shooterMotor.setNeutralMode(NeutralModeValue.Coast);
    topMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Power", power);
    //only put in two variables
  }
}

