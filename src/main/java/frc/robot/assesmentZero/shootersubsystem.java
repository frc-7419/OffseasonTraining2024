// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assesmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shootersubsystem extends SubsystemBase {
  private final TalonFX armRaiseMotor;
  private final TalonFX revShooter1;
  private final TalonFX revShooter2;

  /** Creates a new shootersubsystem. */
  public shootersubsystem() {

    this.armRaiseMotor = new TalonFX(0);
    this.revShooter1 = new TalonFX(1);
    this.revShooter2 = new TalonFX(2);

     public void runArmRaiseMotor (double power){

      armRaiseMotor.set(power);
    }
    public void coastArmRaiseMotor (){
      armRaiseMotor.setNeutralMode (NeutralModeValue.Coast);

    }
    public void brakeRaiseMotor (){
      armRaiseMotor.setNeutralMode (NeutralModeValue.Brake);

    }

    public void revvShooterMotors (double power){

      revShooter1.set(power);
      revShooter2.set(power);
    }
    public void coastArmRaiseMotor (){
      revShooter1.setNeutralMode (NeutralModeValue.Coast);
      revShooter2.setNeutralMode (NeutralModeValue.Coast);

    }
    public void brakeRaiseMotor (){
      revShooter1.setNeutralMode (NeutralModeValue.Brake);
      revShooter2.setNeutralMode (NeutralModeValue.Brake);

    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
