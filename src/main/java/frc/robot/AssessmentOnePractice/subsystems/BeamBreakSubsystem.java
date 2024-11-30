// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.AssessmentOnePractice.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Add your docs here. */
public class BeamBreakSubsystem {
    private final DigitalInput beamBreakFront;
    private final DigitalInput beamBreakBack;
    public BeamBreakSubsystem(){
        beamBreakFront = new DigitalInput(0);
        beamBreakBack = new DigitalInput(1);

    }
    public boolean frontBeamBreakIsTriggered(){
        return !(beamBreakFront.get());
    }
    public boolean backBeamBreakIsTriggered(){
     return !(beamBreakBack.get());
    }
    public void periodic(){
        SmartDashboard.putBoolean("Beam Brake Front triggered",frontBeamBreakIsTriggered());
        SmartDashboard.putBoolean("Beam Brake Back triggered",backBeamBreakIsTriggered());

    }
}
