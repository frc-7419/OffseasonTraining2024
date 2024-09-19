// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessment0;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private TalonFX shooterMotor1;
  private TalonFX shooterMotor2;
  private TalonFX angleMotor;

  public ShooterSubsystem() {
    this.shooterMotor1 = new TalonFX(0);
    this.shooterMotor2 = new TalonFX(1);
    shooterMotor2.setInverted(true);
    this.angleMotor = new TalonFX(2);
  }



  public void setAngle(double angle) {
    // Set the angle of the note motor
    angleMotor.setPosition(angle);
  }

  public void setPower(double power) {
    // Set the power of the shooter motors
    shooterMotor1.set(power);
    shooterMotor2.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter Motor 1 Current Velocity", shooterMotor1.getVelocity().getValueAsDouble());
    SmartDashboard.putNumber("Shooter Motor 2 Current Velocity", shooterMotor2.getVelocity().getValueAsDouble());
    if(shooterMotor1.getVelocity().getValueAsDouble() != 0 && shooterMotor2.getVelocity().getValueAsDouble() != 0) {
      SmartDashboard.putString("Shooter Status", "Shooting");
    }
    else{
      SmartDashboard.putString("Shooter Status", "Not Shooting");
    }
    SmartDashboard.putNumber("Angle Motor Current Position", angleMotor.getPosition().getValueAsDouble());
  }

  public void coast() {
    // Set the shooter to coast mode
    shooterMotor1.setNeutralMode(NeutralModeValue.Coast);
    shooterMotor2.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brakeShooter() {
    // Set the shooter to brake mode
    shooterMotor1.setNeutralMode(NeutralModeValue.Brake);
    shooterMotor2.setNeutralMode(NeutralModeValue.Brake);
  }

  public void brake() {
    // Set the shooter to brake mode
    shooterMotor1.setNeutralMode(NeutralModeValue.Brake);
    shooterMotor2.setNeutralMode(NeutralModeValue.Brake);
    angleMotor.setNeutralMode(NeutralModeValue.Brake);
  }
}
