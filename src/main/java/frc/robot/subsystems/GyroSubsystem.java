// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
  private final AHRS gyro;
  /** Creates a new GyroSubsystem. */
  public GyroSubsystem() {
    this.gyro = new AHRS(SPI.Port.kMXP);
  }

  @Override
  public void periodic() {
  }
  public double yaw() {
    return gyro.getYaw();
  }

  public double roll() {
    return gyro.getRoll();
  }

  public double pitch() {
    return gyro.getPitch();
  }
}
