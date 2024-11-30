// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.AssessmentOnePractice.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.signals.NeutralModeValue;


/** Add your docs here. */
public class ShooterSubsystem {
    private final TalonFX leftShooterMotor;
    private final TalonFX rightShooterMotor;
    public ShooterSubsystem(){
        this.leftShooterMotor = new TalonFX(0);
        this.rightShooterMotor = new TalonFX(1);

    }
    public void runMotor(double speed){
        leftShooterMotor.set(speed);
        rightShooterMotor.set(speed);
    }

    public void coast(){
        leftShooterMotor.setNeutralMode(NeutralModeValue.Coast);
        rightShooterMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake(){
        leftShooterMotor.setNeutralMode(NeutralModeValue.Brake);
        rightShooterMotor.setNeutralMode(NeutralModeValue.Brake);      
    }

    public void periodic(){
        SmartDashboard.putNumber("leftShooterMotor Power", leftShooterMotor.getMotorVoltage().getValue());
        SmartDashboard.putNumber("rightShooterMotor Power", leftShooterMotor.getMotorVoltage().getValue());

    }
}
