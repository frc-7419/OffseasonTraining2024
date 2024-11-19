// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDriveFieldSensor extends SubsystemBase {
  /** Creates a new SwerveDriveFieldSensor. */
  private final AnalogEncoder encoder;
  public SwerveDriveFieldSensor() {
    encoder = new AnalogEncoder(0);
    //Absolute encoder class
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
