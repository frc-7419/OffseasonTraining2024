// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.learnAuton;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.arcadeDrive.arcadeDriveSubsystem;
import frc.robot.commands.PidControl;
import frc.robot.subsystems.ArmSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class jawtonomoues extends SequentialCommandGroup {
  /** Creates a new jawtonomoues. */
  public jawtonomoues(ArmSubsystem armSubsystem, arcadeDriveSubsystem drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ParallelCommandGroup(
        new PidControl(armSubsystem, 100),
        new TranslateDistance(drive, 4.0),
        // new WaitCommand(5.0)   Alternative Way
      )//.withTimeout(5.0).deadlineWith(new WaitCommand(5.0).raceWith(new WaitCommand(5.0))) // Use the one you like --> Dont use all of them at once
    );
  }
}
