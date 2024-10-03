// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import com.kauailabs.navx.frc.AHRS;
// import edu.wpi.first.wpilibj.SPI;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class GyroSubsystem extends SubsystemBase {
//   private final AHRS gyroAHRS;

//   /** Creates a new GyroSubsystem. */
//   public GyroSubsystem() {
//     this.gyroAHRS = new AHRS(SPI.Port.kMXP);
//     gyroAHRS.zeroYaw();
//   }

//   @Override
//   public void periodic() {
//   }
//   public double yawAHRS() {
//     return gyroAHRS.getYaw();
//   }

//   public double rollAHRS() {
//     return gyroAHRS.getRoll();
//   }

//   public double pitchAHRS() {
//     return gyroAHRS.getPitch();
//   }
  
// }


/** OLD CODE - REFER TO TANKDRIVESUBSYSTEM - Aryan */