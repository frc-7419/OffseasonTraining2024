// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Assesment0;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MoveSubsystem extends SubsystemBase {
  private static final String NeutralModeValue = null;
  private final Falcon500 moveMotor3;
  /** Creates a new IntakeSubsystem. */
  public MoveSubsystem() {
    this.moveMotor3 = new Falcon500();
  }
  public void runMotor(double power){
    moveMotor3.set(power);
  }
  public void coast(){
    moveMotor3.setNeutralMode(NeutralModeValue.Coast);
  }
  public void Break(){
    moveMotor3.setNeutralMode(NeutralModeValue.Break);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("MoveMotor", moveMotor3.getMotorVoltage().getValue());
  }
}
