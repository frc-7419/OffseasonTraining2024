// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivebaseSubsystem extends SubsystemBase {
  /** Creates a new DrivebaseSubsystem. */
  private TalonFX FrontLeft, FrontRight, BackLeft, BackRight;
  public DrivebaseSubsystem(int frontLeftID, int frontRightID, int backLeftID, int backRightID) {
    FrontLeft = new TalonFX(frontLeftID);
    FrontRight = new TalonFX(frontRightID);
    BackLeft = new TalonFX(backLeftID);
    BackRight = new TalonFX(backRightID);
  }

  public void setPower(double leftPower, double rightPower) {
    FrontLeft.setPower(leftPower);
    FrontRight.setPower(rightPower);
    BackLeft.setPower(leftPower);
    BackRight.setPower(rightPower);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left motor power", FrontLeft.power());
    SmartDashboard.putNumber("Right motor power", FrontRight.power());
  }
  
  public void setIndividualPower(double frontLeftPower, double FrontRightPower, double backLeftPower, double backRightPower) {
    FrontLeft.setPower(frontLeftPower);
    FrontRight.setPower(FrontRightPower);
    BackLeft.setPower(backLeftPower);
    BackRight.setPower(backRightPower);
  }

}
