// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;


public class AccelerometerSubsystem extends SubsystemBase {
  /** Creates a new AccelerometerSubsystem. */
  private final AHRS ahrs;

  public AccelerometerSubsystem() {
    ahrs = new AHRS();
  }

  // Getters for the AHRS object
  //gets the yaw of the robot
  public double getYaw() {
    return ahrs.getYaw();
  }

  public double getAccelX() {
    return ahrs.getWorldLinearAccelX();
  }

  public double getAccelY() {
    return ahrs.getWorldLinearAccelY();
  }

  public double getAccelXY() {
    return Math.sqrt(Math.pow(getAccelX(), 2) + Math.pow(getAccelY(), 2));
  }

  public double getCompassHeading() {
    return ahrs.getCompassHeading();
  }

  public double getVelocityX() {
    return ahrs.getVelocityX();
  }

  public double getVelocityY() {
    return ahrs.getVelocityY();
  }
  public double getVelocityXY() {
    return Math.sqrt(Math.pow(getVelocityX(), 2) + Math.pow(getVelocityY(), 2));
  }

  public void reset() {
    ahrs.reset();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Yaw", getYaw());
    SmartDashboard.putNumber("Accel X", getAccelX());
    SmartDashboard.putNumber("Accel Y", getAccelY());
    SmartDashboard.putNumber("Accel XY", getAccelXY());
    SmartDashboard.putNumber("Compass Heading", getCompassHeading());
    SmartDashboard.putNumber("Velocity X", getVelocityX());
    SmartDashboard.putNumber("Velocity Y", getVelocityY());
    SmartDashboard.putNumber("Velocity XY", getVelocityXY());
  }
}
