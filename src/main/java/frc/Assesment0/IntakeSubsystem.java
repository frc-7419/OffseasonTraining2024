// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Assesment0;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private static final String NeutralModeValue = null;
  private final Falcon500 intakeMotor1;
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    this.intakeMotor1 = new Falcon500();
  }
  public void runMotor(double power){
    intakeMotor1.set(power);
  }
  public void coast(){
    intakeMotor1.setNeutralMode(NeutralModeValue.Coast);
  }
  public void Break(){
    intakeMotor1.setNeutralMode(NeutralModeValue.Break);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Intake Motor", intakeMotor1.getMotorVoltage().getValue());
  }
}
