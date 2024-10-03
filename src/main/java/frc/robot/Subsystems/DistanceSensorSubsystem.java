// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.Rev2mDistanceSensor;
import com.revrobotics.Rev2mDistanceSensor.Port;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DistanceSensorSubsystem extends SubsystemBase {
  private final Rev2mDistanceSensor distMXP;
  public DistanceSensorSubsystem() {
    this.distMXP = new Rev2mDistanceSensor(Port.kMXP);
    
  }
  public double getRange(){
    return distMXP.getRange();
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("distance sensor range", distMXP.getRange());
  }
}
