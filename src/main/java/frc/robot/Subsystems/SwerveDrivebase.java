// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDrivebase extends SubsystemBase {
  private final SwerveModule leftFrontModule;
  private final SwerveModule rightFrontModule;
  private final SwerveModule leftBackModule;
  private final SwerveModule rightBackModule;
  private final Pigeon2 gyro;
  public SwerveDrivebase() {
    leftFrontModule = new SwerveModule(0, 1, "Left Front Module");
    rightFrontModule = new SwerveModule(2, 3, "Right Front Module");
    leftBackModule = new SwerveModule(4, 5, "Left Back Module");
    rightBackModule = new SwerveModule(6, 7, "Right Back Module");
    gyro = new Pigeon2(8);
  }
  public void setSwerveModuleState(SwerveModuleState[] state) {
    leftFrontModule.setModule(state[0]);
    rightFrontModule.setModule(state[1]);
    leftBackModule.setModule(state[2]);
    rightBackModule.setModule(state[3]);
  }
  public void setSwerveModuleStateWithChassisSpeeds(ChassisSpeeds chassisSpeeds) {
    setSwerveModuleState(new SwerveDriveKinematics().toSwerveModuleStates(chassisSpeeds));
  }
  public ChassisSpeeds getChassisSpeedsFromControllerInput(double leftStickX, double leftStickY, double rightStickX) {
    return ChassisSpeeds.fromFieldRelativeSpeeds(leftStickX,leftStickY,rightStickX, gyro.getRotation2d());
  }
  public void brake(){
    leftBackModule.brake();
    rightBackModule.brake();
    leftFrontModule.brake();
    rightFrontModule.brake(); 
  }
  public void coast(){
    leftBackModule.Coast();
    rightBackModule.Coast();
    leftFrontModule.Coast();
    rightFrontModule.Coast();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
