// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystemAssesmentPracticeTest extends SubsystemBase {
  public final TalonFX armMotor;
  /** Creates a new ArmSubsystemAssesmentPracticeTest. */
  
  public ArmSubsystemAssesmentPracticeTest() {
    this.armMotor = new TalonFX(deviceId:0);
    
  }
  public void runMotor

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
