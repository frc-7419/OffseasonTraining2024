package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDriveSubsystem extends SubsystemBase {
    private static final double DEAD_BAND = 0.05; // Define a deadband threshold
    // Create instances of SwerveModules
    private SwerveModule leftFront;
    private SwerveModule rightFront;
    private SwerveModule leftBack;
    private SwerveModule rightBack;

    public SwerveDriveSubsystem() {
      this.rightFront = new SwerveModule(0, 4, 8, 9, 0.1, 0, 0);
      this.rightBack =  new SwerveModule(1, 5, 10, 11, 0.1, 0, 0);
      this.leftFront =  new SwerveModule(2, 6, 12, 13, 0.1, 0, 0);
      this.leftBack = new SwerveModule(3, 7, 14, 15, 0.1, 0, 0);

    }

    public void drive(double xSpeed, double ySpeed, double rotation) {

        // Apply deadband using ternary operators
        if (Math.abs(xSpeed)<DEAD_BAND){
          xSpeed = 0;
        }
        if (Math.abs(ySpeed)<DEAD_BAND){
          ySpeed = 0;
        }
        if (Math.abs(rotation)<DEAD_BAND){
          rotation = 0;
        }
        //Doesn't move unless significant
        
        // Calculate target angles and speeds
        double frontLeftSpeed = ySpeed + xSpeed + rotation;
        double frontRightSpeed = ySpeed - xSpeed - rotation;
        double backLeftSpeed = ySpeed - xSpeed + rotation;
        double backRightSpeed = ySpeed + xSpeed - rotation;

        // Set drive for each module with target angles
        leftFront.drive(frontLeftSpeed, 0); // Replace with calculated angles
        rightFront.drive(frontRightSpeed, 0);
        leftBack.drive(backLeftSpeed, 0);
        rightBack.drive(backRightSpeed, 0);
    }
}