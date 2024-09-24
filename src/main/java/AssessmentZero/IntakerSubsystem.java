// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package AssessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intaker extends SubsystemBase {
  private final TalonFX IntakerMech;
  private TalonFX Intake;

  /** Creates a new ArmSubsystem. */
  public Intaker() {
    this.Intaker = new TalonFX(0);
  }
  public static void main(String[] args) {
    
  }
}

