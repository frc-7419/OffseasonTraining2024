package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeSubsystem extends SubsystemBase {
    private TalonFX intakeMotorTop;
    private TalonFX intakeMotorBottom;
    // topMotorID and botomMotor ID represent 
    public IntakeSubsystem(int topMotorID, int bottomMotorID) {
        intakeMotorTop = new TalonFX(topMotorID);
        intakeMotorBottom = new TalonFX(bottomMotorID);
    }
    public void IntakeSpeed(double intakeSpeed) {
        intakeMotorTop.set(ControlMode.PercentOutput, intakeSpeed);
        intakeMotorBottom.set(ControlMode.PercentOutput, intakeSpeed);
    }
    public void coast() {
        intakeMotorTop.setNeutralMode(NeutralModeValue.Coast)
        intakeMotorBottom.setNeutralMode(NeutralModeValue.Coast);
    }
    public void brake() {
        intakeMotorTop.setNeutralMode(NeutralModeValue.Brake)
        intakeMotorBottom.setNeutralMode(NeutralModeValue.Brake);
    }
    public void stopIntake() {
        intakeMotorTop.set(ControlMode.PercentOutput, 0);
        intakeMotorBottom.set(ControlMode.PercentOutput, 0);
    }

    SmartDashboard.putNumber("Intake top motor voltage", intakeMotorTop.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Intake bottom motor voltage", intakeMotorBottom.getMotorVoltage().getValue());

}
