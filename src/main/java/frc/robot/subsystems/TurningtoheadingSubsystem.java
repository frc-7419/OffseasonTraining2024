package frc.robot.subsystems;

// Import necessary classes for SmartDashboard, SubsystemBase, and AHRS for gyro functionality
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

// Define the TurningSubsystem that handles turning to a set heading
public class TurningtoheadingSubsystem extends SubsystemBase {
    private final AHRS ahrs; // Instance of the AHRS class. Used for accessing gyro data
    private double targetHeading; // The desired heading to turn towards
    private final double tolerance = 1.0; // Tolerance in degrees for heading accuracy
    private final double kp = 0.03; // Proportional gain for turning

    // Constructor for the TurningSubsystem
    public TurningtoheadingSubsystem() {
        this.ahrs = new AHRS(); // Initialize the AHRS object for gyro functionality
        this.targetHeading = 0; // Default target heading
    }

    // Method to set the target heading
    public void setTargetHeading(double heading) {
        this.targetHeading = heading; // Set the desired heading in degrees
    }

    // Method to retrieve the current yaw angle from the gyro
    public double getGyroYaw() {
        return ahrs.getYaw(); // Returns the yaw value from AHRS
    }

    // Method to check if the current heading is within the tolerance of the target heading
    public boolean isHeadingCorrect() {
        return Math.abs(getGyroYaw() - targetHeading) < tolerance; // Check if the heading is within tolerance
    }

    // Method to calculate the turn rate needed to reach the target heading
    public double calculateTurnRate() {
        double currentHeading = getGyroYaw();
        double angleDiff = (targetHeading - currentHeading + 180) % 360 - 180; // Shortest angle to turn
        return kp * angleDiff; // Calculate the turn rate
    }

    // Method called periodically to update the SmartDashboard and control the turning
    @Override
    public void periodic() {
        if (!isHeadingCorrect()) {
            double turnRate = calculateTurnRate();
            // Here you would implement the logic to control your motors based on turnRate
            // For example: driveSubsystem.arcadeDrive(0, turnRate); // Drive forward with turning
        } else {
            // Stop turning when the target heading is reached
            // For example: driveSubsystem.arcadeDrive(0, 0); // Stop driving
        }

        // Display the current heading and target heading on the SmartDashboard
        SmartDashboard.putNumber("Current Heading", getGyroYaw());
        SmartDashboard.putNumber("Target Heading", targetHeading);
    }
}