package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LoaderSubsystem extends SubsystemBase {
    private TalonFX loaderMotorTop;
    private TalonFX loaderMotorBottom;

    public LoaderSubsystem(int topMotorID, int bottomMotorID) {
        loaderMotorTop = new TalonFX(topMotorID);
        loaderMotorBottom = new TalonFX(bottomMotorID);
    }
    public void setLoaderSpeed(double loaderSpeed) {
        loaderMotorTop.set(ControlMode.PercentOutput, loaderSpeed);
        loaderMotorBottom.set(ControlMode.PercentOutput, loaderSpeed);
    }
    public void coast() {
        loaderMotorTop.setNeutralMode(NeutralModeValue.Coast)
        loaderMotorBottom.setNeutralMode(NeutralModeValue.Coast);
    }
    public void brake() {
        loaderMotorTop.setNeutralMode(NeutralModeValue.Brake)
        loaderMotorBottom.setNeutralMode(NeutralModeValue.Brake);
    }
    public void stopLoader() {
        loaderMotorTop.set(ControlMode.PercentOutput, 0);
        loaderMotorBottom.set(ControlMode.PercentOutput, 0);
    }
    public void periodic(){
        SmartDashboard.putNumber("Loader top motor voltage", loaderMotorTop.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Loader bottom motor voltage", loaderMotorBottom.getMotorVoltage().getValue());
    }
    
}
