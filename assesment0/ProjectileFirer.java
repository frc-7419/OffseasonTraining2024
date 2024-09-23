// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ProjectileFirer extends SubsystemBase {
  /** Creates a new ProjectileFirer. */
  //All the instance variables for the components
  Joystick angleControlJoystick;
  XboxController shooterController;
  TalonFX angleMotor, topMotor, bottonMotor;

  public ProjectileFirer() {
    //Initializes the instance variables.
    angleControlJoystick = new Joystick(4);
    shooterController = new XboxController(5);
    angleMotor = new TalonFX(1);
    topMotor = new TalonFX(2);
    bottonMotor = new TalonFX(3);
  }

  //This function sets the angle of the angle motor based
  public void adjustAngle() {
    //This gets the position of the joystick 
    //This probably isn't the best way to do so
    //Maybe we need to do some math on the angle?
    double newAngle = angleControlJoystick.getY();
    //This sets the angle motor to the position
    //This probably isn't the proper way to set the angle
    angleMotor.setPosition(newAngle);
  }

  //This function sets the new speed of the motor
  public void setFlywheelSpeed(double speed) {

    //Sets the new speed of the flywheel motor
    topMotor.set(speed);
    bottonMotor.set(speed);
  }
  // @Override
  // public void periodic() {
  //   if (shooterController.getAButtonPressed()) {
  //     angleMotor.set(0.1);
  //     // angleMotor.setPosition(getCurrentAngle())
  //   } 
  //   if (shooterController.getAButtonReleased()) {
  //     angleMotor.set(0);
  //   } 
  //   if (shooterController.getBButtonPressed()) {
  //     angleMotor.set(-0.1);
  //   } 
  //   if (shooterController.getAButtonReleased()) {
  //     angleMotor.set(0);
  //   } 
  // }

  // public void setFlywheelSpeed(double speed) {
  //   topMotor.set(speed);
  //   bottonMotor.set(speed);
  // }

  // public int getCurrentAngle() {
  //   return angleMotor.getPosition()
  // }
}
