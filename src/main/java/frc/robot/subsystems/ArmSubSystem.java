// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubSystem extends SubsystemBase {
  /** Creates a new ArmSubSystem. */
  private final TalonFX armMotor; // declares our motor
  public armSubSystem() { //creates a new talonfx object called arm motor with device id 0
    this.armMotor = new TalonFX(0);
  }
  public void runMotor(double power) {  //runes the motor and accepts parameter power
    armMotor.set(power);


  }
  public void coast() {  //sets the arms neutral mode to coast
    armMotor.setNeutralMode(NeutralModeValue.Coast);

  }
  public void brake() { //brakes the arm
    armMotor.setNeutralMode(NeutralModeValue.Brake);

  }
  @Override
  public void periodic() { //gives us the arms current voltage.
    SmartDashboard.putNumber("Arm motor Voltage", armMotor.getMotorVoltage().getValue()); //bonus
  }
}
