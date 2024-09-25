// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package makeUpAssessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  public final TalonFX intakeMotor0;
  public final TalonFX intakeMotor1;
  private final double speed;
  public IntakeSubsystem(double speed) {
    this.intakeMotor0 = new TalonFX(2);
    this.intakeMotor1 = new TalonFX(3);
    this.speed = speed;

  }
  public void CoastIntake(){
    intakeMotor0.setNeutralMode(NeutralModeValue.Coast);
    intakeMotor1.setNeutralMode(NeutralModeValue.Coast);

  }

  public void BrakeIntake(){
    intakeMotor0.setNeutralMode(NeutralModeValue.Brake);
    intakeMotor1.setNeutralMode(NeutralModeValue.Brake);
  }

  public void RunIntake(){
    intakeMotor0.set(speed);
    intakeMotor1.set(speed);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("First Intake Voltage: ", intakeMotor0.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Second Intake Voltage: ", intakeMotor1.getMotorVoltage().getValue());
    // This method will be called once per scheduler run
  }
}
