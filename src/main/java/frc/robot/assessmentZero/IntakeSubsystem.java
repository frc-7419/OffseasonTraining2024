package frc.robot.assessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    //Declares the inital motors
    private final TalonFX leftIntake;
    private final TalonFX rightIntake;

    public IntakeSubsystem() {
        //Setting the motors
        leftIntake = new TalonFX(1);
        rightIntake = new TalonFX(2);
    }

    public void setSpeed(double speed) {
        leftIntake.set(ControlMode.PercentOutput, speed);
        rightIntake.set(ControlMode.PercentOutput, speed);
    }

    public void setVoltage(double voltage) {
        leftIntake.setVoltage(voltage);
        rightIntake.setVoltage(voltage);
    }

    public void setPower(double power) {
        leftIntake.set(power);
        rightIntake.set(power);
    }

    public void brake() {
        leftIntake.setNeutralMode(NeutralMode.Brake);
        rightIntake.setNeutralMode(NeutralMode.Brake);
    }

    public void coast() {
        leftIntake.setNeutralMode(NeutralMode.Coast);
        rightIntake.setNeutralMode(NeutralMode.Coast);
    }
}
