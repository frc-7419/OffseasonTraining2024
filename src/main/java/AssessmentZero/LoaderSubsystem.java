// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package AssessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {
  private final TalonFX LoaderMech;

  public LoaderSubsystem() {
    this.LoaderMech = new TalonFX(0);
  }
  public void MotorPower(double power) {
    LoaderMech.set(power);
  }
    public void StopLoader() {
    // Stops Loader
    LoaderMech.setNeutralMode(NeutralModeValue.Brake);
  }


}

