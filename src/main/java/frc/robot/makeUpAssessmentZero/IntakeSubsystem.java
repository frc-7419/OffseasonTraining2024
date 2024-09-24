package frc.robot.makeUpAssessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    // Declare both intake motors as TalonFX motors.
    private final TalonFX intakeMotor1;
    private final TalonFX intakeMotor2;

    // Constructor to intialize both intake motors.
    public IntakeSubsystem() {
        this.intakeMotor1 = new TalonFX(0);
        this.intakeMotor2 = new TalonFX(1);
    }

    // This method runs the intake motors at a given power.
    public void runIntakeMotors(double power) {
        intakeMotor1.set(power);
        intakeMotor2.set(power);
    }

    // This method coasts the intake motors.   
    public void coastIntakeMotors() {
        intakeMotor1.setNeutralMode(NeutralModeValue.Coast);
        intakeMotor2.setNeutralMode(NeutralModeValue.Coast);
    }

    // This method brakes (stops) the intake motors.
    public void brakeIntakeMotors() {
        intakeMotor1.setNeutralMode(NeutralModeValue.Brake);
        intakeMotor2.setNeutralMode(NeutralModeValue.Brake);
    }
}