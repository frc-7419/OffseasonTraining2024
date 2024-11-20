// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase {
  private final TalonFX moveMotor;
  private final TalonFX turnMotor;
  private final PIDController pidController;
  private final String moduleName;
  public SwerveModule(int moveMotorId, int turnMotorId, String moduleName) {
    moveMotor = new TalonFX(moveMotorId);
    turnMotor = new TalonFX(turnMotorId);
    pidController = new PIDController(0.1, 0, 0);
    this.moduleName = moduleName;
  }
  public void setModule(SwerveModuleState state) {
    moveMotor.set(state.speedMetersPerSecond*50);
    pidController.setSetpoint(state.angle.getDegrees());
    turnMotor.set(pidController.calculate(turnMotor.getPosition().getValueAsDouble()));
  }
  public void brake(){
    moveMotor.setNeutralMode(NeutralModeValue.Brake);
    turnMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void Coast(){
    moveMotor.setNeutralMode(NeutralModeValue.Coast);
    turnMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
