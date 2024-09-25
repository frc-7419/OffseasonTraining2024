// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package assessmentZeroPartTwo;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterAngleSubsystem extends SubsystemBase {
  public final TalonFX shooterAngle;
  /** Creates a new ShooterAngleSubsystem. */
  public ShooterAngleSubsystem() {
    this.shooterAngle = new TalonFX(3);
  }

  public void AngleShooter(double power, boolean setInverted){
    shooterAngle.setInverted(setInverted);
    shooterAngle.set(power);
  }  
  public void BrakeShooter(){
    shooterAngle.setNeutralMode(NeutralModeValue.Brake);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
