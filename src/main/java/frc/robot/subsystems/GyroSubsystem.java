// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
  private final AHRS gyroAHRS;

  private final Pigeon2 gyroPigeon;

  /** Creates a new GyroSubsystem. */
  public GyroSubsystem() {
    this.gyroAHRS = new AHRS(SPI.Port.kMXP);
    gyroAHRS.zeroYaw();

    gyroPigeon = new Pigeon2(0);
    gyroPigeon.reset();
  }

  @Override
  public void periodic() {
  }
  public double yawAHRS() {
    return gyroAHRS.getYaw();
  }

  public double rollAHRS() {
    return gyroAHRS.getRoll();
  }

  public double pitchAHRS() {
    return gyroAHRS.getPitch();
  }
  

  public double yawPigeon() {
    return gyroPigeon.getAngle();
  }

  public double rollPigeon() {
    return gyroPigeon.getRoll().getValue();
  }

  public double pitchPigeon() {
    return gyroPigeon.getPitch().getValue();
  }
}
