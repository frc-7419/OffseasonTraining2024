package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class mySwerveModule {
    public static final double distancePerRotation = 1.337; // The distance in meters per rotation
    private final TalonFX aria, est;
    private final AnalogEncoder shiro, hanako;
    // public final SwerveModulePosition chloe;
    public mySwerveModule(int moveMotorID, int moveEncoderID, int spinMotorID, int spinEncoderID) {
        aria = new TalonFX(moveMotorID);
        shiro = new AnalogEncoder(moveEncoderID);
        est = new TalonFX(spinMotorID);
        hanako = new AnalogEncoder(moveEncoderID);
        shiro.setDistancePerRotation(distancePerRotation);
        hanako.setDistancePerRotation(2 * Math.PI);
        chloe = new SwerveModulePosition();
    }

    public void brake() {
        aria.setNeutralMode(NeutralModeValue.Brake);
        est.setNeutralMode(NeutralModeValue.Brake);
    }

    public void coast() {
        aria.setNeutralMode(NeutralModeValue.Coast);
        est.setNeutralMode(NeutralModeValue.Coast);
    }   

    public void setMoveMotorSpeed(double speed) {
        aria.setPower(speed);
    }

    public double getMoveMotorSpeed() {
        return aria.power();
    }
    public void setSpinMotorSpeed() {
        est.setPower(speed);
    }

    public double getSpinMotorSpeed() {
        return est.power();
    }

    public double getMoveDistance() {
        return shiro.getDistance();
    }
    public double getSpinDistance() {
        return hanako.getDistance();
    }
    public void resetMoveDistance() {
        throw new IllegalStateException("To do: Implement this function");
    }
    public SwerveModulePosition getPosition() {
        return new SwerveModulePosition(getMoveDistance(), new Rotation2d(getSpinDistance()));
    }
}
