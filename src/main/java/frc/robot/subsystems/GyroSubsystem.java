package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

public class GyroSubsystem extends SubsystemBase {

    public GyroSubsystem() {
        AHRS ahrs = new AHRS();
    }

    public double getGyroYaw() {
    }

    public double getGyroPitch() {
    }

    public double getGyroRoll() {  
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Gyro Yaw", getGyroYaw());
        SmartDashboard.putNumber("Gyro Pitch", getGyroPitch());
        SmartDashboard.putNumber("Gyro Roll", getGyroRoll());
    }
}