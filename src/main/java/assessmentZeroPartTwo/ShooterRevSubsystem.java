// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package assessmentZeroPartTwo;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterRevSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  public final TalonFX shooterRev0;
  public final TalonFX shooterRev1;
  public ShooterRevSubsystem() {
    this.shooterRev0 = new TalonFX(1);
    this.shooterRev1 = new TalonFX(2);
  }
  public void RevShooter(double power){
    shooterRev0.set(power);
    shooterRev1.set(power);
  }

  public void BrakeShooter(){
    shooterRev0.setNeutralMode(NeutralModeValue.Brake);
    shooterRev0.setNeutralMode(NeutralModeValue.Brake); 
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
