// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivebaseSubsystem extends SubsystemBase {
  /** Creates a new DrivebaseSubsystem. */
  private TalonFX FrontLeft, FrontRight, BackLeft, BackRight;
  public DrivebaseSubsystem() {
    FrontLeft = new TalonFX(1);
    FrontRight = new TalonFX(1);
    BackLeft = new TalonFX(1);
    BackRight = new TalonFX(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  //Coasting -
  public void coast() {
      MikuBondage.setNeutralMode(NeutralModeValue.valueOf("Coast"));
  }

}
