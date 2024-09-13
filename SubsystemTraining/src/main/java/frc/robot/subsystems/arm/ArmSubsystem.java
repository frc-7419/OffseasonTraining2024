// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;



import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private TalonFX motor;
  final DutyCycleOut m_Request = new DutyCycleOut(12.0);

  public ArmSubsystem() {
    motor = new TalonFX(13);
  }

  public void setSpeed(double speed) {
    motor.set(speed);
  }

  public void setVoltage(double voltage) {
    motor.setControl(m_Request.withOutput(voltage));
  }

  public void brake() {
    motor.setNeutralMode(NeutralModeValue.Brake);
    
  }

  public void coast() {
    motor.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
