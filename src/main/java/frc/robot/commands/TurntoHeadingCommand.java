package frc.robot.commands;

// Import necessary classes for commands and subsystems
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TurningSubsystem;

// Define a command that turns the robot to a specified heading
public class TurnToHeadingCommand extends Command {
    private final TurningSubsystem turningSubsystem; // The turning subsystem
    private final double targetHeading; // The desired heading to turn towards

    // Constructor for TurnToHeadingCommand, taking in the turning subsystem and target heading
    public TurnToHeadingCommand(TurningSubsystem turningSubsystem, double targetHeading) {
        this.turningSubsystem = turningSubsystem; // Initialize the turning subsystem
        this.targetHeading = targetHeading; // Set the desired heading

        // Declare that this command requires the turning subsystem
        addRequirements(turningSubsystem);
    }

    @Override
    public void initialize() {
        // Set the target heading in the turning subsystem
        turningSubsystem.setTargetHeading(targetHeading);
    }

    @Override
    public void execute() {
        // The turning subsystem will handle turning logic during command execution
    }

    // Method to determine if the command has completed
    @Override  
    public boolean isFinished() {
        // The command finishes when the heading is within tolerance
        return turningSubsystem.isHeadingCorrect();
    }

    @Override
    public void end(boolean interrupted) {
        // Stop any turning action when the command ends or is interrupted
        // For example: driveSubsystem.arcadeDrive(0, 0); // Stop the robot
    }
}
