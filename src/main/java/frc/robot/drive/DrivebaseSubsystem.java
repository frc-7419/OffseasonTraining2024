// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package drive;

import com.studica.frc.AHRS;

import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Operator.SwerveConstants;
import frc.robot.Constants.Operator.SwerveModuleConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveBase. */
  public SwerveModule frontRight;
  public SwerveModule frontLeft;
  public SwerveModule backRight;
  public SwerveModule backLeft;
  public final SwerveDriveOdometry odometry;
  public AHRS ahrs;
  public DriveSubsystem() {
    this.odometry = new SwerveDriveOdometry
    frontRight = new SwerveModule(SwerveConstants.frontRight.turnMotorID, SwerveConstants.frontRight.driveMotorID, SwerveConstants.frontRight.turnEncoderID,SwerveConstants.frontRight.offset);// dont know what to put for these offsets
    frontLeft = new SwerveModule(SwerveConstants.frontLeft.turnMotorID, SwerveConstants.frontLeft.driveMotorID, SwerveConstants.frontLeft.turnEncoderID, SwerveConstants.frontLeft.offset);
    backRight = new SwerveModule(SwerveConstants.backRight.turnMotorID, SwerveConstants.backRight.driveMotorID, SwerveConstants.backRight.turnEncoderID, SwerveConstants.backRight.offset);
    backRight = new SwerveModule(SwerveConstants.backLeft.turnMotorID, SwerveConstants.backLeft.driveMotorID, SwerveConstants.backLeft.turnEncoderID, SwerveConstants.backLeft.offset);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void getPitch(){
    ahrs.getPitch();
  }
  public void resetYaw(){
    ahrs.zeroYaw();
  }
  public void getYaw(){
    ahrs.getYaw();
  }
  public void getRoll(){
    ahrs.getRoll();
  }
  public void resetEncoder(){
    
  }
}