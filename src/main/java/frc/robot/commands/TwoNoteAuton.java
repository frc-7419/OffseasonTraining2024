package frc.robot.commands;

import edu.wpi.first.math.proto.Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.SwerveDriveSubsystem;

public class TwoNoteAuton extends SequentialCommandGroup {

    public TwoNoteAuton(SwerveDriveSubsystem swerveDriveSubsystem) {
        // First "note" - Move forward at 50% speed for 2 seconds
        addCommands(
            new SwerveDriveCommand(swerveDriveSubsystem,controller,0.5, 0.0, 0.0),  // Move forward at 50% speed
            new WaitCommand(2)  // Wait for 2 seconds to complete the movement
        );

        // Second "note" - Strafe right at 50% speed for 1 second
        addCommands(
            new SwerveDriveCommand(swerveDriveSubsystem, controller, 0.0, 0.5, 0.0),  // Strafe right at 50% speed
            new WaitCommand(1)  // Wait for 1 second to complete the strafe
        );
    }
}
