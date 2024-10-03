package frc.robot.commands;

// Import necessary classes for commands and subsystems
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.GyroSubsystem;

// Define a command that coordinates the arm's movements based on gyro readings
public class GyroArmCommand extends Command {
    private final ArmSubsystem arm;
    private final GyroSubsystem gyro;

    // Constructor for GyroArmCommand, taking in the arm and gyro subsystems
    public GyroArmCommand(ArmSubsystem arm, GyroSubsystem gyro) {
        this.arm = arm; // Initialize arm subsystem
        this.gyro = gyro; // Initialize the gyro subsystem

        // Declare that this command requires both the arm and gyro subsystems
        addRequirements(arm);
        addRequirements(gyro);
    }

    @Override
    public void execute() {
        // If the pitch is greater than 90 degrees, the arm will move up to maintain position
        if (gyro.getGyroPitch() > 90) {
            arm.runMotor(0.5); //Motor Speed: 0.5
            arm.brake(); // Brake is engaged to hold arm in position
        }
    }

    // Method to determine if the command has completed
    @Override  
    public boolean isFinished() {
        return false; //Command runs indefinately
    }
}