// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package drive;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants.SwerveConstants;

/** Add your docs here. */
public class SwerveModule {
    private final CANSparkMax turnMotor;
    private final CANSparkMax driveMotor;
    private final CANcoder turnCoder;
    private final RelativeEncoder driveCoder;
    private final PIDController anglecController;
    /**
     * @param driveMotorId
     * @param turnMotorId
     */
    
    
    
    public SwerveModule(int turnMotorId, int driveMotorId){
        this.anglecController = new PIDController(SwerveConstants.anglekP, SwerveConstants.anglekI, SwerveConstants.anglekD);

        
    }
}
