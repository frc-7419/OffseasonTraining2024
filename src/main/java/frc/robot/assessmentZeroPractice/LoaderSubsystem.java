// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZeroPractice;

import javax.swing.text.TabExpander;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {
  /** Creates a new LoaderSubsystem. */
  private final TalonFX loaderMotorOne;
  private final TalonFX loaderMotorTwo;
  public LoaderSubsystem() {
    this.loaderMotorOne = new TalonFX(0);
    this.loaderMotorTwo = new TalonFX(1);

  }

    public void coast(){
      loaderMotorOne.setNeutralMode(NeutralModeValue.Coast);
      loaderMotorTwo.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake(){
            loaderMotorOne.setNeutralMode(NeutralModeValue.Brake);
                  loaderMotorOne.setNeutralMode(NeutralModeValue.Brake);
    }
    public void setPower(double loadPower){
      loaderMotorOne.set(loadPower);
      loaderMotorTwo.set(loadPower);
    }
  @Override
  public void periodic() {
SmartDashboard.putNumber("Loader Motor One Voltage", loaderMotorOne.getMotorVoltage().getValue()) 
SmartDashboard.putNumber("Load Motor Two Voltage", loaderMotorTwo.getMotorVoltage().getValue());
 }
}
