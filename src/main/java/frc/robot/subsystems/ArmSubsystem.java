// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArrmSubsystem. */
  private final TalonFX armMotor;

  public ArmSubsystem() {
    this.armMotor = new TalonFX(0);
  
  }
    public void runMotor (double power){
      armMotor.setPower (power);
    }
    public void coast (){
      armMotor.setNeutralMode (NeutralModeValue.coast);

    }
    public void brake (){
      armMotor.setNeutralMode (NeutralModeValue.brake);
      
    }


  @Override
  public void periodic() {
    SmartDashboard.putNumber(key:"Arm motor voltage", armMotor.getMotorVoltage().getValue());
    // This method will be called once per scheduler run
  }
}
