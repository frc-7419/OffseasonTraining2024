package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
	private final TalonFX armMotor;

	public ArmSubsystem() {
		this.armMotor = new TalonFX(1234);
	}

	public void runMotor(double power) {
		armMotor.set(power);
	}

	public void coast() {
		armMotor.setNeutralMode(NeutralModeValue.Coast);
	}

	public void brake() {
		armMotor.setNeutralMode(NeutralModeValue.Brake);
	}

	@Override
	public void periodic() {
		SmartDashboard.putNumber("Motor Voltage (arm)", armMotor.getMotorVoltage().getValue());
	}
}
