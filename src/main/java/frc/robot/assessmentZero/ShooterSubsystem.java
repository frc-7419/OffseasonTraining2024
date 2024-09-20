// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX shooterArmMotor; //motor for adjusting shooter arm
  private final TalonFX shootProjMotorOne; //1st motor for rev
  private final TalonFX shootProjMotorTwo; //2nd motor for rev
  public ShooterSubsystem() {
    //constructor for setting up the deviceId for all motors
    shooterArmMotor = new TalonFX(0); 
    shootProjMotorOne = new TalonFX(1);
    shootProjMotorTwo = new TalonFX(2);
  }
  public void moveShooterArm(double speed){
    //function for moving shooter arm with the parameter speed
    shooterArmMotor.set(speed);
  }
  public void coastShooterArm(){
    //function for coasting the shooter arm
    shooterArmMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void coastRevShooterMotors(){
    //function for coasting rev shooter motors
    shootProjMotorOne.setNeutralMode(NeutralModeValue.Coast);
    shootProjMotorTwo.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brakeRevShooterMotors(){
    //function for braking rev shooter motors
    shootProjMotorOne.setNeutralMode(NeutralModeValue.Brake);
    shootProjMotorTwo.setNeutralMode(NeutralModeValue.Brake);
  }
  public void brakeShooterArm(){
    //function for braking shooter arm
    shooterArmMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void revShooterMotor(){
    //function for moving both motors used for revving
    shootProjMotorOne.set(1);
    shootProjMotorTwo.set(1);
  }
  @Override
  public void periodic() {
    //putting voltage values to smart dashboard
    SmartDashboard.putNumber("Shooter Arm Motor Voltage", shooterArmMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Rev Shooter 1 Motor Voltage", shootProjMotorOne.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Rev Shooter 2 Motor Voltage", shootProjMotorTwo.getMotorVoltage().getValue());
    
  }
}
