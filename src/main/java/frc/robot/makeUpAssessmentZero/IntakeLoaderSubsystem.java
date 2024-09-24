// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.makeUpAssessmentZero;

// import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
public class IntakeLoaderSubsystem extends SubsystemBase{
    private final TalonFX intakeMotorBottom;
    private final TalonFX intakeMotorTop;
    private final TalonFX loaderMotorBottom;
    private final TalonFX loaderMotorTop;

    public IntakeLoaderSubsystem(){
        this.intakeMotorBottom = new TalonFX(0);
        this.intakeMotorTop = new TalonFX(1);
        this.loaderMotorBottom = new TalonFX(2);
        this.loaderMotorTop = new TalonFX(3);
    }

    public void setIntakeSpeed(double intakeSpeed){
        intakeMotorBottom.set(intakeSpeed);
        intakeMotorTop.set(intakeSpeed);
    }

    public void IntakeBrake(){
        intakeMotorBottom.setNeutralMode(NeutralModeValue.Brake);
        intakeMotorTop.setNeutralMode(NeutralModeValue.Brake);
    }
    
    public void IntakeCoast(){
        intakeMotorBottom.setNeutralMode(NeutralModeValue.Coast);
        intakeMotorTop.setNeutralMode(NeutralModeValue.Coast);
    }

    public void LoaderBrake(){
        loaderMotorBottom.setNeutralMode(NeutralModeValue.Brake);
        loaderMotorTop.setNeutralMode(NeutralModeValue.Brake);
    }
    
    public void LoaderCoast(){
        loaderMotorBottom.setNeutralMode(NeutralModeValue.Coast);
        loaderMotorTop.setNeutralMode(NeutralModeValue.Coast);
    }

    public void setLoaderSpeed(double loaderSpeed){
        loaderMotorBottom.set(loaderSpeed);
        loaderMotorTop.set(loaderSpeed);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Intake Motor Bottom Voltage", intakeMotorBottom.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Intake Motor Top Voltage", intakeMotorTop.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Loader Motor Bottom Voltage", loaderMotorBottom.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Loader Motor Top Voltage", intakeMotorTop.getMotorVoltage().getValue());

        if (intakeMotorBottom.getMotorVoltage().getValue() != 0 && intakeMotorTop.getMotorVoltage().getValue() != 0) {
            SmartDashboard.putString("Intake Subsystem", "is Running");
        } else {
            SmartDashboard.putString("Intake Subsystem", "isn't Running");
        }

        if (loaderMotorBottom.getMotorVoltage().getValue() != 0 && loaderMotorTop.getMotorVoltage().getValue() != 0) {
            SmartDashboard.putString("Loader Subsystem", "is Running");
        } else {
            SmartDashboard.putString("Loader Subsystem", "isn't Running");
        }
    }
}
