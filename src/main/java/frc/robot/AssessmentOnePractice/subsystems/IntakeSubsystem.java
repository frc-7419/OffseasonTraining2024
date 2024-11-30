// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.AssessmentOnePractice.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.signals.NeutralModeValue;


/** Add your docs here. */
public class IntakeSubsystem {
    private final TalonFX leftIntakeMotor;
    private final TalonFX rightIntakeMotor;
    public IntakeSubsystem(){
        this.leftIntakeMotor = new TalonFX(0);
        this.rightIntakeMotor = new TalonFX(1);

    }
    public void runMotor(double speed){
        leftIntakeMotor.set(speed);
        rightIntakeMotor.set(speed);
    }

    public void coast(){
        leftIntakeMotor.setNeutralMode(NeutralModeValue.Coast);
        rightIntakeMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake(){
        leftIntakeMotor.setNeutralMode(NeutralModeValue.Brake);
        rightIntakeMotor.setNeutralMode(NeutralModeValue.Brake);      
    }

    public void periodic(){
        SmartDashboard.putNumber("leftIntakeMotor Power", leftIntakeMotor.getMotorVoltage().getValue());
        SmartDashboard.putNumber("rightIntakeMotor Power", leftIntakeMotor.getMotorVoltage().getValue());

    }
}
