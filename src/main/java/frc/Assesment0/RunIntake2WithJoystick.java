// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Assesment0;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RunIntake2WithJoystick extends Command {
  private final IntakeSubsystem2 intake;
  private final CommandXboxController joystick;

  /** Creates a new RunIntakeWithJoystick. */
  public RunIntake2WithJoystick(IntakeSubsystem2 intake, CommandXboxController joystick) {
    this.intake = intake;
    this.joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.runMotor(joystick.getLeftY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.Break();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}