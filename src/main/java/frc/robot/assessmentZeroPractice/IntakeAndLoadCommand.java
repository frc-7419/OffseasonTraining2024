// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZeroPractice;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class IntakeAndLoadCommand extends Command {
  /** Creates a new IntakeAndLoadCommand. */
  private final LoaderSubsystem loaderSubsystem;
  private final IntakeSubsystem intakeSubsystem;
  private final CommandXboxController joystick;
  public IntakeAndLoadCommand(LoaderSubsystem loaderSubsystem, IntakeSubsystem intakeSubsystemm, CommandXboxController joystick) {
    this.loaderSubsystem = loaderSubsystem;
    this.intakeSubsystem = intakeSubsystemm;
    this.joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    loaderSubsystem.coast();
    intakeSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      loaderSubsystem.setPower(joystick.getLeftY());
      intakeSubsystem.setPower(joystick.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    loaderSubsystem.brake();
    intakeSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
