// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//Imports the CANID from the constants class
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private TalonFX armMotor;
  public ArmSubsystem() {
    //Sets the armMotor to a CANID
    this.armMotor = new TalonFX(ArmConstants.armCANID);
  }
  public void runMotor(double power) {
      armMotor.set(power);
  }
  public void coast() {
      armMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake() {
      armMotor.setNeutralMode(NeutralModeValue.Brake);
      armMotor.getPosition();
  }
  public double getPosition() {
    return  armMotor.getPosition().getValueAsDouble();
  }
  public double getVelocity() {
    return armMotor.getVelocity().getValueAsDouble();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //Puts the display on the dashboard
    SmartDashboard.putNumber("Arm Motor Voltage", armMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Arm Position", armMotor.getPosition().getValue());
  }
}
