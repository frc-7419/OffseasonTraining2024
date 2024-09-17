// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubSystem extends SubsystemBase {
  /** Creates a new ArmSubSystem. */
  private final TalonFx armMotor;
  public ArmSubSystem() {
    this.armMotor = new TalonFx(deviceId:0);
  }
  public void runMotor(double power) { 
    armoMotor.set(power);


  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void coast() {
    armMotor.setNeutralMode(NeutralModeValue.Coast);

  }
  public void brake() {
    armMotor.setNeutralMode(NeutralModeValue.brake)

  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Arm motor Voltage", armMotor.getMotorVoltage().getValue());
  }
}
