// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.MakeUpAssessment0;

import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubSystem extends SubsystemBase {
  /** Creates a new LoaderSubSystem. */
  private final  intakeMotor1;
  private final intakeMotor2;
  public LoaderSubSystem() { //creating our  new motors  
    this.intakeMotor1 = new TalonFX(0);
    this.intakeMotor2 = new TalonFX(1);


  }
  public void coast(){
    intakeMotor1.setNeutralMode(NeutralModeValue.Coast)
    intakeMotor2.setNeutralMode(NeutralModeValue.Coast)

  }
  public void brake(){
    Object intakeMotor1Motor1;
    intakeMotor1Motor1.setNeutralMode(NeutralModeValue.Brake)
    Object intakeMotor2;
    intakeMotor2.setNeutralMode(NeutralModeValue.Brake)
    


  }
  public void runMotor(double power){
    loaderMotor1.set(power)
    loaderMotor2.set(power)
    

  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("voltage of loader motor 1 is" + intakeMotor1.getMotorVoltage())
    SmartDashboard.putNumber("voltage of loader motor 2 is" + intakeMotor2.getMotorVoltage())
  }
}
