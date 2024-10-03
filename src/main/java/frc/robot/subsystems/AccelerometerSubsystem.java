// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;


public class AccelerometerSubsystem extends SubsystemBase {
  /*We usually need the analog import, and specifiy which one
  , but since we are using NAVX we don't need to */
  /** Creates a new AccelerometerSubsystem. */
  private final AHRS ahrs;
  /*private final because we don't want to change it */

  public AccelerometerSubsystem() {
    ahrs = new AHRS();
    /* ahrs: altituteheadingreferencesystem: An attitude and heading reference system (AHRS) is a device that 
     provide estimation of an objects and orientation in, can integrate accelerometer 
     Measurements of pitch, roll, and yaw are typical data outputs.
     pitch: Side-to-side axis rotation(y axis)
     roll: Front-to-back axis rotation(x axis)
     yaw: Rotation around vertical axis
     */
    
  }

  // Getters for the AHRS object
  //gets the yaw of the robot
  public double getYaw() {
    return ahrs.getYaw();
  }

  //Acceleration on X axis
  public double getAccelX() {
    return ahrs.getWorldLinearAccelX();
  }

  //Acceleration on Y axis
  public double getAccelY() {
    return ahrs.getWorldLinearAccelY();
  }

  //Accleration on XY axis
  public double getAccelXY() {
    return Math.sqrt(Math.pow(getAccelX(), 2) + Math.pow(getAccelY(), 2));
  }
  //Compass Heading: Angle relative to north
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

  //reset
  public void reset() {
    ahrs.reset();
  }

  @Override
  public void periodic() {
    //displays values on SmartDashboard
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
