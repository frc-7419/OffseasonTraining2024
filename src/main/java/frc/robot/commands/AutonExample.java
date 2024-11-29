package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Auton extends ParallelCommandGroup {
    public Auton(IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem, ArcadeDrive arcadeDrive) {

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