// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package assessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new shooterSubsystem. */
  public final TalonFX shooterMotor;

  public shooterSubsystem() {
    this.shooterMotor = new TalonFX(0);

  }

  public void runMotor(double power, boolean inverted){
    shooterMotor.setInverted(inverted);
    shooterMotor.set(power);
  }
  public void brake(){
    shooterMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coast(){
    shooterMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
