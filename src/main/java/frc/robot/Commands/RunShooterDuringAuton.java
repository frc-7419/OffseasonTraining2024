// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class RunShooterDuringAuton extends SequentialCommandGroup {
  /** Creates a new RunShooterDuringAuton. */
  public RunShooterDuringAuton(ShooterSubsystem shooterSubsystem) {
    addCommands(
      new ParallelRaceGroup(
        new WaitCommand(2),
        new RunCommand(()->shooterSubsystem.runShooter(0.9), shooterSubsystem)
      )
    );
  }
}
