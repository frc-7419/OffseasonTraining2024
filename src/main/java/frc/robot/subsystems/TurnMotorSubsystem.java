// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurnMotorSubsystem extends SubsystemBase {
  int MOTOR_NUM = 4;
  int[] turnMotorIds = {8, 6, 2, 4};
  int[] encoderIds = {4, 3, 1, 2};
  TalonFX motors[] = new TalonFX[MOTOR_NUM];
  CANcoder encoders[] = new CANcoder[MOTOR_NUM];
  double[] offsets = {-0.234130859375, 0.12878125, -0.096923828125, 0.417236328125};
  public TurnMotorSubsystem() {
    for (int i = 0; i < MOTOR_NUM; i++) {
      motors[i] = new TalonFX(turnMotorIds[i], "Ryan Biggee");
      encoders[i] = new CANcoder(encoderIds[i], "Ryan Biggee");
    }
  }

  public TalonFX[] getMotors() {
    return motors;
  }

  public double[] getOffsets() {
    return offsets;
  }

  public CANcoder[] getEncoders() {
    return encoders;
  }

  public int getNumMotors() {
    return MOTOR_NUM;
  }

  @Override
  public void periodic() {
    for (int i = 0; i < MOTOR_NUM; i++) {
      double position = encoders[i].getAbsolutePosition().getValueAsDouble();
      String title = "Encoder " + i + " value";
      SmartDashboard.putNumber(title, position);
    }
  }
}
