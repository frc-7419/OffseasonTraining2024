// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.AssessmentOnePractice.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.signals.NeutralModeValue;
/** Add your docs here. */
public class ArmSubsystem {
    private final TalonFX armMotor;
    public ArmSubsystem(){
        this.armMotor = new TalonFX(0);
    }
    public void runMotor(double speed){
        armMotor.set(speed);
    }


    public void coast(){
        armMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake(){
        armMotor.setNeutralMode(NeutralModeValue.Brake);  
    }

    public void periodic(){
        SmartDashboard.putNumber("armMotorPower", armMotor.getMotorVoltage().getValue());
    }
}
