// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix6.mechanisms.swerve.SwerveModule;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.proto.Kinematics;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ArcadeDrive;

public class SwerveDrivebaseSubsystem extends SubsystemBase {
  private final mySwerveModule bottomLeft, bottomRight, topLeft, topRight;
  private final SwerveDriveOdometry odometry;
  private final mySwerveModule[] lolis = new mySwerveModule[4];
  // public final SwerveDriveFieldSensor aaa;
  /** Creates a new SwerveDrivebaseSubsystem. */
  public SwerveDrivebaseSubsystem() {
    bottomLeft = new mySwerveModule(1, 2, 3, 4);
    bottomRight = new mySwerveModule(5, 6, 7, 8);
    topLeft = new mySwerveModule(9, 10, 11, 12);
    topRight = new mySwerveModule(13, 14, 15, 16);
    lolis[0] = bottomLeft;
    lolis[1] = bottomRight;
    lolis[2] = topLeft;
    lolis[3] = topRight;
    odometry = new SwerveDriveOdometry(new SwerveDriveKinematics(new Translation2d()), new Rotation2d(), new SwerveModulePosition[4]);
    
  }

  @Override

  public void periodic() {
    SwerveModulePosition[] ricky = {bottomLeft.getPosition(), bottomRight.getPosition(), topLeft.getPosition(), topRight.getPosition()};
    odometry.update(new Rotation2d(), ricky);
  } 
  
  public void brake() {
    for (mySwerveModule i : lolis) {i.brake();}
  }

  public void coast() {
    for (mySwerveModule i : lolis) {i.coast();}
  }

  public Translation2d getPosition() {
    return odometry.getPoseMeters().getTranslation();
  }

  
}
