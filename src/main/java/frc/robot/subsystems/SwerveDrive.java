package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDrive extends SubsystemBase {
    private static final double DEAD_BAND = 0.05; // Define a deadband threshold
    // Create instances of SwerveModules
    private SwerveModule Leftfront = new SwerveModule(0, 4, 8, 9, 0.1, 0, 0);
    private SwerveModule Rightfront = new SwerveModule(1, 5, 10, 11, 0.1, 0, 0);
    private SwerveModule Leftback = new SwerveModule(2, 6, 12, 13, 0.1, 0, 0);
    private SwerveModule Rightback = new SwerveModule(3, 7, 14, 15, 0.1, 0, 0);

    public SwerveDrive() {
        // Initialization if needed
    }

    public void drive(double xSpeed, double ySpeed, double rotation) {

        // Apply deadband using ternary operators
        xSpeed = (Math.abs(xSpeed) < DEAD_BAND) ? 0 : xSpeed;
        ySpeed = (Math.abs(ySpeed) < DEAD_BAND) ? 0 : ySpeed;
        rotation = (Math.abs(rotation) < DEAD_BAND) ? 0 : rotation;

        // Calculate target angles and speeds
        double LeftfrontSpeed = ySpeed + xSpeed + rotation;
        double RightfrontSpeed = ySpeed - xSpeed - rotation;
        double LeftbackSpeed = ySpeed - xSpeed + rotation;
        double RightbackSpeed = ySpeed + xSpeed - rotation;

        // Set drive for each module with target angles
        Leftfront.drive(LeftfrontSpeed, 0); // Replace with calculated angles
        Rightfront.drive(RightfrontSpeed, 0);
        Leftback.drive(LeftbackSpeed, 0);
        Rightback.drive(RightbackSpeed, 0);
    }
}