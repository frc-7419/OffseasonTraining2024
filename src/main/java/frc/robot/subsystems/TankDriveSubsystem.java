// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class TankDriveSubsystem extends TimedRobot {
  double kP = 1;

  double heading;

  PWMSparkMax left1 = new PWMSparkMax(0);
  PWMSparkMax left2 = new PWMSparkMax(1);

  PWMSparkMax right1 = new PWMSparkMax(2);
  PWMSparkMax right2 = new PWMSparkMax(3);

  DifferentialDrive drive;

  private final AHRS gyro = new AHRS(SPI.Port.kMXP);


  @Override
  public void robotInit() {
    left1.addFollower(left2);
    right1.addFollower(right2);
    right1.setInverted(true);
  }

  @Override
  public void autonomousInit() {
    // Set setpoint to current heading at start of auto
    heading = gyro.getYaw();
    drive = new DifferentialDrive(left1::set, right1::set);
  }

  @Override
  public void autonomousPeriodic() {
    double error = heading - gyro.getYaw();
    drive.tankDrive(.5 + kP * error, .5 - kP * error);
  }

  public double getHeading() {
    return gyro.getYaw();
  }

  public void tankDrive(double a, double b) {
    drive.tankDrive(a, b);
  }

}

/** EDITED CODE TO WORK WITH STABALIZEHEADINGCOMMAND */

// package frc.robot.subsystems;

// import com.kauailabs.navx.frc.AHRS;
// import edu.wpi.first.wpilibj.SPI;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class TankDriveSubsystem extends SubsystemBase {
//   double kP = 1;
//   double heading;

//   PWMSparkMax left1 = new PWMSparkMax(0);
//   PWMSparkMax left2 = new PWMSparkMax(1);
//   PWMSparkMax right1 = new PWMSparkMax(2);
//   PWMSparkMax right2 = new PWMSparkMax(3);
//   public DifferentialDrive drive;

//   // Gyro
//   private final AHRS gyro = new AHRS(SPI.Port.kMXP);

//   public TankDriveSubsystem() {
//     left1.addFollower(left2);
//     right1.addFollower(right2);
//     right1.setInverted(true);
    
//     drive = new DifferentialDrive(left1, right1);
//   }

//   public void tankDrive(double leftSpeed, double rightSpeed) {
//     drive.tankDrive(leftSpeed, rightSpeed);
//   }

//   public void getHeading() {
//     heading = gyro.getAngle();  //current heading
//   }
// }
