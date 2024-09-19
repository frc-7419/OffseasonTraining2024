package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
    private final TalonFX armMotor;
    private final TalonFX armRotator;

    public ExampleSubsystem() {
        this.armMotor = new TalonFX(0);
        this.armRotator = new TalonFX(1);
    }

    public void coast() {
        armMotor.setNeutralMode(NeutralModeValue.Coast);
        armRotator.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
        armMotor.setNeutralMode(NeutralModeValue.Brake);
        armRotator.setNeutralMode(NeutralModeValue.Brake);
    }

    public void runMotor(double motorSpeed, double rotatorSpeed) {
        armMotor.set(motorSpeed);
        armRotator.set(rotatorSpeed);
    }

    @Override
    public void periodic(){

    }
}
