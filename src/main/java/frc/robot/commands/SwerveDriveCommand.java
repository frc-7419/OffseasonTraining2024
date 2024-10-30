package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveDriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class SwerveDriveCommand extends CommandBase {
    private final XboxController controller;
    private final SwerveDriveSubsystem swerveDriveSubsystem;

    public SwerveDriveCommand(SwerveDriveSubsystem swerveDriveSubsystem, XboxController controller) {
        this.swerveDriveSubsystem = swerveDriveSubsystem; // Initialize from parameter
        this.controller = controller;
        addRequirements(swerveDriveSubsystem);
    }

    @Override
    public void execute() {
        // Control inputs from the Xbox controller
        double xSpeed = controller.getLeftY(); // Left Stick Y-axis
        double ySpeed = controller.getLeftX(); // Left Stick X-axis
        double rotation = controller.getRightX(); // Right Stick X-axis

        // Call the drive method on the swerve drive subsystem
        swerveDriveSubsystem.drive(xSpeed, ySpeed, rotation);
    }

    @Override
    public boolean isFinished() {
        return false; // This command will run until interrupted
    }
}
