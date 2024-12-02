// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.SwerveDriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoNoteAuton extends ParallelCommandGroup {
  /** Creates a new TwoNoteAuton. */
  public TwoNoteAuton(ArmSubsystem armMotor, ShooterCommand shooterSubsystem ,SwerveDriveSubsystem swerveDriveSubsystem) {
   
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    new SequentialCommandGroup(
      new RunArm(armMotor),
      new ShooterCommand(shooterSubsystem),
      new WaitCommand(2)
  );
  // Second sequence: Swerve drive followed by a 3-second wait
  new SequentialCommandGroup(
      new SwerveDriveCommand(swerveDriveSubsystem,XboxController, 0.5, 0.3, 0.7),
      new WaitCommand(3)
  );
  }
}
