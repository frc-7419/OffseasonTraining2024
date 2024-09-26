// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubSystem extends SubsystemBase {
  /** Creates a new ArmSubSystem. */
  private final TalonFx armMotor; // defines motor
  public ArmSubSystem() {
    this.armMotor = new TalonFx(deviceId:0); //creates a new object of type talonfx with deviceID 0
  }
  public void runMotor(double power){ //constructor for the runMotor() command that accepts parameter of power
    armMotor.set(power);


  }
  @Override // lets us know that we intend to ovveride this code
  public void periodic() { //dont know for thus one
    // This method will be called once per scheduler run
  }
  public void coast() { //coast command method that sets neutral mode value to coast
    armMotor.setNeutralMode(NeutralModeValue.Coast);

  }
  public void brake() { //same as before but sets to brake
    armMotor.setNeutralMode(NeutralModeValue.brake)

  }
  @Override
  public void periodic() { //dont know what this does but my best guess is that it displays voltage.
    SmartDashboard.putNumber("Arm motor Voltage", armMotor.getMotorVoltage().getValue());
  }
}
