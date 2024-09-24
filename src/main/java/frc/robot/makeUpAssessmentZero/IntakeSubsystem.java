// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.makeUpAssessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new subsystem for this class. It has two motors and one joystick for input.
   * 
   */
  public TalonFX topMotor, bottomMotor;
  public Joystick intakeInputController;
  public IntakeSubsystem() {
    topMotor = new TalonFX(1);
    bottomMotor = new TalonFX(2);
    intakeInputController = new Joystick(3);
  }
  
  /*
   * Sets the speed of the motor
   * 0 means turned off 
   * 1 means powered
   */
  public void setMotorSpeed(double speed) {
    topMotor.set(speed);
    bottomMotor.set(speed);
  }

  //Checks if the button for the subsystem is pressed
  public boolean isButtonPressed() {
    return intakeInputController.getRawButton(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
