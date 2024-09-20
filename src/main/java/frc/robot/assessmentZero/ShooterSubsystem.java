package frc.robot.assessmentZero;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem extends SubsystemBase {

    private final TalonFX shooterAngleMotor;
    private final TalonFX topFlywheelMotor;
    private final TalonFX bottomFlywheelMotor;
    private final double power;

    public shooterSubsystem() {
        this.shooterAngleMotor = new TalonFX(ShooterConstant.shooterCANID);
        this.topFlywheelMotor = new TalonFX(topFlywheelMotor.topFlywheelMotorCANID);
        this.bottomFlywheelMotor = new TalonFX(bottomFlywheelMotor.bottomFlywheelMotorCANID));
    }

    public void coast() {
        shooterAngleMotor.setNeutralMode(NeutralModeValue.Coast);
        topFlywheelMotor.setNeutralMode(NeutralModeValue.Coast);
        bottomFlywheelMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
    shooterAngleMotor.setNeutralMode(NeutralModeValue.Brake);
    topFlywheelMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomFlywheelMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    public void runMotor(double shooterAngleMotorSpeed, double topFlywheelMotorSpeed, double bottomFlywheelMotorSpeed) {
        shooterAngleMotor.set(shooterAngleMotorSpeed);
        topFlywheelMotor.set(topFlywheelMotorSpeed);
        bottomFlywheelMotor.set(bottomFlywheelMotorSpeed);
    }

    public void periodic() {
        SmartDashboard.putNumber("Power", getName(), power);
    }
}
