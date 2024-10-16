// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubSystem extends SubsystemBase {
  /** Creates a new ArmSubSystem. */
  private final TalonFX armMotor; // defines motor
  DutyCycleEncoder encoder = new DutyCycleEncoder(0);

  public ArmSubSystem() {
    this.armMotor = new TalonFX(0); //creates a new object of type talonfx with deviceID 0
  }
  public void set(double power){ //constructor for the runMotor() command that accepts parameter of power
    armMotor.set(power);


  }

  public void coast() { //coast command method that sets neutral mode value to coast
    armMotor.setNeutralMode(NeutralModeValue.Coast);

  }
  public void brake() { //same as before but sets to brake
    armMotor.setNeutralMode(NeutralModeValue.Brake);

  }
  @Override
  public void periodic() { //dont know what this does but my best guess is that it displays voltage.
    SmartDashboard.putNumber("Arm motor Voltage", armMotor.getMotorVoltage().getValue());
  }
  public double getPosition() {
    return encoder.getAbsolutePosition() - encoder.getPositionOffset();



  }
}
