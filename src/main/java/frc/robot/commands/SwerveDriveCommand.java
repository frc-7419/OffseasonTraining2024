package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveDriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class SwerveDriveCommand extends Command {
    private final XboxController controller;
    private final SwerveDriveSubsystem swerveDriveSubsystem;
    private final double xSpeed;  // Forward/Backward Speed
    private final double ySpeed;  // Strafe Speed
    private final double rotation; // Rotation Speed (turning)


    public SwerveDriveCommand(SwerveDriveSubsystem swerveDriveSubsystem, XboxController controller, double xSpeed, double ySpeed, double rotation) {
        this.swerveDriveSubsystem = swerveDriveSubsystem; // Initialize from parameter
        this.controller = controller;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.rotation = rotation;
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
