// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SensorAssignment;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensor extends SubsystemBase {
  private final TalonFX moveMotorOne;
  private final TalonFX moveMotorTwo;
  
  AnalogPotentiometer pot = new AnalogPotentiometer(0, 180, 30);
  /** Creates a new Sensor. */
  public Sensor(TalonFX moveMotorOne, TalonFX moveMotorTwo) {
    this.moveMotorOne = moveMotorOne;
    this.moveMotorTwo = moveMotorTwo;
  }


  public void coast(){
    moveMotorOne.setNeutralMode(NeutralModeValue.Coast);
    moveMotorTwo.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake(){
    moveMotorOne.setNeutralMode(NeutralModeValue.Brake);
    moveMotorTwo.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setPower(double speed){
    moveMotorOne.set(speed);
    moveMotorTwo.set(speed);
  }


  public double getSensorDistance(){
    return (pot.get());

  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Distance from Target", getSensorDistance());
    // This method will be called once per scheduler run
  }
}
