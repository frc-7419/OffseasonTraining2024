// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Assesment0;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem2 extends SubsystemBase {
  private static final String NeutralModeValue = null;
  private final Falcon500 intakeMotor2;
  /** Creates a new IntakeSubsystem2. */
  public IntakeSubsystem2() {
    this.intakeMotor2 = new Falcon500();
  }
  public void runMotor(double power){
    intakeMotor2.set(power);
  }
  public void coast(){
    intakeMotor2.setNeutralMode(NeutralModeValue.Coast);
  }
  public void Break(){
    intakeMotor2.setNeutralMode(NeutralModeValue.Break);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
        SmartDashboard.putNumber("Intake Motor", intakeMotor2.getMotorVoltage().getValue());
  }
}
