// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.drive;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArcadeDriveBaseSubsystem extends SubsystemBase {
  private final TalonFX leftLeaderMotor;
  private final TalonFX leftFollowerMotor;
  private final TalonFX rightLeaderMotor;
  private final TalonFX rightFollowerMotor;

  public ArcadeDriveBaseSubsystem() {
    leftLeaderMotor = new TalonFX(Constants.CANIds.leftFalcon1.id);
    leftFollowerMotor = new TalonFX(Constants.CANIds.leftFalcon2.id);
    rightLeaderMotor = new TalonFX(Constants.CANIds.rightFalcon1.id);
    rightFollowerMotor = new TalonFX(Constants.CANIds.rightFalcon2.id);

    leftLeaderMotor.setInverted(true);
    leftFollowerMotor.setInverted(true);
    rightLeaderMotor.setInverted(true);
    rightFollowerMotor.setInverted(true);
  }

    public void coast() {
        leftLeaderMotor.setNeutralMode(NeutralMode.Coast);
        leftFollowerMotor.setNeutralMode(NeutralMode.Coast);
        rightLeaderMotor.setNeutralMode(NeutralMode.Coast);
        rightFollowerMotor.setNeutralMode(NeutralMode.Coast);
    }

  public void brake() {
        leftLeaderMotor.setNeutralMode(NeutralMode.Brake);
        leftFollowerMotor.setNeutralMode(NeutralMode.Brake);
        rightLeaderMotor.setNeutralMode(NeutralMode.Brake);
        rightFollowerMotor.setNeutralMode(NeutralMode.Brake); 
  }

    public void factoryResetAll() {
        leftLeaderMotor.configFactoryDefault();
        leftFollowerMotor.configFactoryDefault();
        rightLeaderMotor.configFactoryDefault();
        rightFollowerMotor.configFactoryDefault();
    }

  public void setPower(double leftPower, double rightPower) {
    leftLeaderMotor.set(ControlMode.PercentOutput, leftPower);
    leftFollowerMotor.set(ControlMode.PercentOutput, leftPower);
    rightLeaderMotor.set(ControlMode.PercentOutput, rightPower);
    rightFollowerMotor.set(ControlMode.PercentOutput, rightPower);
  }

  @Override
  public void periodic() {}
}