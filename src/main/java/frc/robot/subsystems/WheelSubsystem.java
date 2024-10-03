// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WheelSubsystem extends SubsystemBase {
  //new wheel Motor
  private final TalonFX wheelMotor;

  public WheelSubsystem() {
    this.wheelMotor = new TalonFX(0);
  }

  //run the motor
  public void runMotor(double power) {
    wheelMotor.set(power);
    
  }
  //get velocity
  public void getMotorVelocity(){
    wheelMotor.getVelocity();
  }

  public void coast() {
    wheelMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    wheelMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  //show on smart dashboard
  public void periodic() {
    SmartDashboard.putNumber("WheelMotor velocity", wheelMotor.getVelocity().getValue());
    SmartDashboard.putNumber("wheelMotor voltage", wheelMotor.getMotorVoltage().getValue());
  }
}
