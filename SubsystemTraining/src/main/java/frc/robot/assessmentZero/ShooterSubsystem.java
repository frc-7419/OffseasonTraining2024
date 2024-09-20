package frc.robot.assessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    private TalonFX angleMotor;
    private TalonFX flyWheel1;
    private TalonFX flyWheel2;

    public ShooterSubsystem() {
        angleMotor = new TalonFX(0);
        flyWheel1 = new TalonFX(1);
        flyWheel2 = new TalonFX(2);
    }

    public void brake() {
        angleMotor.setNeutralMode(NeutralModeValue.Brake);
        flyWheel1.setNeutralMode(NeutralModeValue.Brake);
        flyWheel2.setNeutralMode(NeutralModeValue.Brake);
    }

    public void coast() {
        angleMotor.setNeutralMode(NeutralModeValue.Coast);
        flyWheel1.setNeutralMode(NeutralModeValue.Coast);
        flyWheel2.setNeutralMode(NeutralModeValue.Coast);
    }

    public void setFlywheelSpeed(double power) {
        flyWheel1.set(power);
        flyWheel2.set(power);
    }

    public void adjustAngle(double angle) {
        angleMotor.set(angle);
    }

    public void shootNote(boolean fireButtonPressed, int flywheelSpeed) {
        if (fireButtonPressed) {
            setFlywheelSpeed(flywheelSpeed);
        }
    }

    public void stopFiring() {
        flyWheel1.setNeutralMode(NeutralModeValue.Brake);
        flyWheel2.setNeutralMode(NeutralModeValue.Brake);
    }

    public void display() {
        System.out.println("Angle Motor position: " + angleMotor.getPosition());
        // System.out.println("Angle Motor angle: " + (angleMotor.getVelocity())/360);
    }

    @Override
    public void periodic() {

    }
} 
