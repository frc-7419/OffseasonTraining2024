// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
/** 
  WPI_PigeonIMU gyro = new WPI_PigeonIMU(0); 
  TalonSRX talon = new TalonSRX(0); // TalonSRX is on CAN Bus with device ID 0
  WPI_PigeonIMU gyro = new WPI_PigeonIMU(talon); // Pigeon uses the talon created above
*/
  private final AHRS gyroAHRS;

  /** Creates a new GyroPresentationSubsystem. */
  public GyroSubsystem() {
    this.gyroAHRS = new AHRS(SPI.Port.kMXP); 
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Gyro Yaw", getGyroYaw());
    SmartDashboard.putNumber("Gyro Pitch", getGyroPitch());
    SmartDashboard.putNumber("Gyro Roll", getGyroRoll());

  }

      public double getGyroYaw() {
      return gyroAHRS.getYaw();
    }

    public double getGyroPitch() {
      return gyroAHRS.getPitch();
    }

    public double getGyroRoll() {
      return gyroAHRS.getRoll();
    }

  public double yawARHS() {

  }
  
}
