package frc.robot.subsystems;

// Import necessary classes for SmartDashboard, SubsystemBase, and AHRS for gyro functionality
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

// Define the GyroSubsystem that handles gyro sensor readings
public class GyroSubsystem extends SubsystemBase {
    private final AHRS ahrs; // Instance of the AHRS class. Used for accessing gyro data

    // Constructor for the GyroSubsystem
    public GyroSubsystem() {
        this.ahrs = new AHRS(); // Initialize the AHRS object for gyro functionality
    }

    // Method to retrieve the current yaw angle from the gyro
    public double getGyroYaw() {
        return ahrs.getYaw(); // Returns the yaw value from AHRS
    }

    // Method to retrieve the current pitch angle from the gyro
    public double getGyroPitch() {
        return ahrs.getPitch(); // Returns the pitch value from AHRS
    }

    // Method to retrieve the current roll angle from the gyro
    public double getGyroRoll() { 
        return ahrs.getRoll(); // Returns the roll value from AHRS
    }

    // Method called periodically to update the SmartDashboard with gyro readings
    @Override
    public void periodic() {
        // Display the current yaw, pitch, and roll values on the SmartDashboard
        SmartDashboard.putNumber("Gyro Yaw", getGyroYaw());
        SmartDashboard.putNumber("Gyro Pitch", getGyroPitch());
        SmartDashboard.putNumber("Gyro Roll", getGyroRoll());
    }
}