package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDriveSubsystem extends SubsystemBase {
    // Create instances of SwerveModules
    private SwerveModule frontLeft = new SwerveModule(0, 4, 8, 9, 0.1, 0, 0);
    private SwerveModule frontRight = new SwerveModule(1, 5, 10, 11, 0.1, 0, 0);
    private SwerveModule backLeft = new SwerveModule(2, 6, 12, 13, 0.1, 0, 0);
    private SwerveModule backRight = new SwerveModule(3, 7, 14, 15, 0.1, 0, 0);

    public SwerveDriveSubsystem() {
        // Initialization if needed
    }

    public void drive(double xSpeed, double ySpeed, double rotation) {
        // Calculate target angles and speeds
        double frontLeftSpeed = ySpeed + xSpeed + rotation;
        double frontRightSpeed = ySpeed - xSpeed - rotation;
        double backLeftSpeed = ySpeed - xSpeed + rotation;
        double backRightSpeed = ySpeed + xSpeed - rotation;

        // Set drive for each module with target angles
        frontLeft.drive(frontLeftSpeed, 0); // Replace with calculated angles
        frontRight.drive(frontRightSpeed, 0);
        backLeft.drive(backLeftSpeed, 0);
        backRight.drive(backRightSpeed, 0);
    }
}
