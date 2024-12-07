//needs review
package frc.robot.subsystems;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Encoder;

public class SwerveModule {
    private Spark driveMotor;
    private Spark steerMotor;
    private Encoder encoder;
    private PIDController PID;
    private double currentAngle;

    // Constructor
    public SwerveModule(int driveMotorId, int steerMotorId, int encoderA, int encoderB, double P, double I, double D) {
        this.driveMotor = new Spark(driveMotorId);
        this.steerMotor = new Spark(steerMotorId);
        this.encoder = new Encoder(encoderA, encoderB); 
        this.PID = new PIDController(P, I, D);
        this.currentAngle = 0; 
    }

    public void drive(double speed, double targetAngle) {
        driveMotor.set(speed);

        // Update the current angle from the encoder
        currentAngle = encoder.get(); // Adjust this if you have a different scale

        // Calculate the steering adjustment using PID
        double steerOutput = PID.calculate(currentAngle, targetAngle);
        steerMotor.set(steerOutput);
    }

    public void setCurrentAngle(double angle) {
        this.currentAngle = angle; // Update the current angle
    }

    public double getCurrentAngle() {
        return currentAngle; // Get the current angle
    }
}