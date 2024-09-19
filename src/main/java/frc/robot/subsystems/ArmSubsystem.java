// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX armMotor;

  public ArmSubsystem() {
    // Initizlie the motor with the ID and CAN bus from our Constants file
    this.armMotor = new TalonFX(ArmConstants.armCANID);
  }

  // Sets the motor to "coast" mode, allowing it to move freely when no power is applied
  public void coast() {
    armMotor.setNeutralMode(NeutralMode.coast);
  }

  // Sets the motor to "brake" mode, stopping the motor when no power is applied
  public void brake() {
    armMotor.setNeutralMode(NeutralMode.brake);
  }   

  @Override
  public void periodic() {
    // I am currently referencing the WPILib docs:
    // https://docs.wpilib.org/en/stable/docs/software/commandbased/subsystems.html
    // While nothing is currently being done, this is where you could monitor motor performance or status
  }

public void runMotor(double leftY) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'runMotor'");
}
}

