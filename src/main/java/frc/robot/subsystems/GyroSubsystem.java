package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

public class GyroSubsystem extends SubsystemBase {
    private final AHRS ahrs;

    public GyroSubsystem() {
        this.ahrs = new AHRS();
    }

    public double getGyroYaw() {
        return ahrs.getYaw();
    }

    public double getGyroPitch() {
        return ahrs.getPitch();
    }

    public double getGyroRoll() { 
        return ahrs.getRoll(); 
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Gyro Yaw", getGyroYaw());
        SmartDashboard.putNumber("Gyro Pitch", getGyroPitch());
        SmartDashboard.putNumber("Gyro Roll", getGyroRoll());
    }
}