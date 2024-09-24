package frc.robot.assessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    //Declares the inital motors
    private final TalonFX leftShooter;
    private final TalonFX rightShooter;

    public ShooterSubsystem() {
        //Setting the motors
        leftShooter = new TalonFX(3);
        rightShooter = new TalonFX(4);
    }

    public void setSpeed(double speed) {
        leftShooter.set(ControlMode.PercentOutput, speed);
        rightShooter.set(ControlMode.PercentOutput, speed);
    }

    public void brake() {
        leftShooter.setNeutralMode(NeutralMode.Brake);
        rightShooter.setNeutralMode(NeutralMode.Brake);
    }

    public void coast() {
        leftShooter.setNeutralMode(NeutralMode.Coast);
        rightShooter.setNeutralMode(NeutralMode.Coast);
    }
}
