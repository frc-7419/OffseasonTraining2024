package frc.robot.makeUpAssessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {
    
    // Declare both loader motors as TalonFX motors.
    private final TalonFX loaderMotor1;
    private final TalonFX loaderMotor2;

    // Constructor to intialize both loader motors.
    public LoaderSubsystem() {
        this.loaderMotor1 = new TalonFX(0);
        this.loaderMotor2 = new TalonFX(1);
    }

    // This method runs the loader motors at a given power.
    public void runLoaderMotors(double power) {
        loaderMotor1.set(power);
        loaderMotor2.set(power);
    }

    // This method coasts the loader motors.   
    public void coastLoaderMotors() {
        loaderMotor1.setNeutralMode(NeutralModeValue.Coast);
        loaderMotor2.setNeutralMode(NeutralModeValue.Coast);
    }

    // This method brakes (stops) the loader motors.
    public void brakeLoaderMotors() {
        loaderMotor1.setNeutralMode(NeutralModeValue.Brake);
        loaderMotor2.setNeutralMode(NeutralModeValue.Brake);
    }
}