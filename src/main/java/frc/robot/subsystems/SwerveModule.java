package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Encoder;

public class SwerveModule {
    private Spark driveMotor;
    private Spark steerMotor;
    private Encoder encoder;
    private PIDController steerPID;
    private double currentAngle;
    
    public SwerveModule(int driveMotorId, int steerMotorId, int encoderA, int encoderB, double p, double i, double d) {
        this.driveMotor = new Spark(driveMotorId);
        this.steerMotor = new Spark(steerMotorId);
        this.encoder = new Encoder(encoderA, encoderB); 
        this.steerPID = new PIDController(p, i, d);
        this.currentAngle = 0; // Initial angle
    }

    public void drive(double speed, double targetAngle) {
        // Set the drive motor speed
        driveMotor.set(speed);

        // Update the current angle from the encoder
        currentAngle = encoder.get(); // Adjust this if you have a different scale

        // Calculate the steering adjustment using PID
        double steerOutput = steerPID.calculate(currentAngle, targetAngle);
        steerMotor.set(steerOutput);
    }

    public void setCurrentAngle(double angle) {
        this.currentAngle = angle; // Update the current angle
    }

    public double getCurrentAngle() {
        return currentAngle; // Get the current angle
    }
}
