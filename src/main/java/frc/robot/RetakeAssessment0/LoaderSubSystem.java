// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.MakeUpAssessment0;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubSystem extends SubsystemBase {
  /** Creates a new LoaderSubSystem. */
  private final loaderMotor1;
  private final loaderMotor2;
  public LoaderSubSystem() { //creating our  new motors  
    this.loaderMotor1 = new TalonFX(0);
    this.loaderMotor1 = new TalonFX(1);


  })
  public void coast(){
    loaderMotor1.setNeutralMode(NeutralModeValue.Coast)
    loaderMotor2.setNeutralMode(NeutralModeValue.Coast)
    
    



  }
  public void brake(){
    loaderMotor1.setNeutralMode(NeutralModeValue.Brake)
    loaderMotor2.setNeutralMode(NeutralModeValue.Brake)
    


  }
  public void runMotor(double power){
    loaderMotor1.set(power)
    loaderMotor2.set(power)
    

  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("voltage of loader motor 1 is" + loaderMotor1.getMotorVoltage())
    SmartDashboard.putNumber("voltage of loader motor 2 is" + loaderMotor2.getMotorVoltage())
  }
}
