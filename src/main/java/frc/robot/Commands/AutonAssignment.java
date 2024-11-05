package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Subsystems.ArcadeDrive;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;

public class AutonAssignment extends ParallelCommandGroup {
    private final IntakeSubsystem intakeSubsystem;
    private final ShooterSubsystem shooterSubsystem;
    private final ArcadeDrive arcadeDrive;
    public AutonAssignment(IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem, ArcadeDrive arcadeDrive) {
        this.intakeSubsystem = intakeSubsystem;
        this.shooterSubsystem = shooterSubsystem;
        this.arcadeDrive = arcadeDrive;

        Command runIntake = new RunCommand(() -> intakeSubsystem.runIntake(0.9), intakeSubsystem);
        Command runShooter = new RunCommand(() -> shooterSubsystem.runShooter(1.0), shooterSubsystem);

        addCommands(
            new SequentialCommandGroup(
                runShooter.withTimeout(1),
                runIntake,
                new TranslateDistance(arcadeDrive, 10),
                new TranslateDistance(arcadeDrive, -10),
                runShooter.withTimeout(1)
            )
        );
    }
}
