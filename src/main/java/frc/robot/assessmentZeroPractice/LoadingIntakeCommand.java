// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZeroPractice;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class LoadingIntakeCommand extends Command {
  private final IntakeSubsytem intakeSubsytem;
  private final LoadingSubsystem loadingSubsystem;
  private final CommandXboxController commandXboxController;
  public LoadingIntakeCommand(IntakeSubsytem intakeSubsytem, LoadingSubsystem loadingSubsystem, CommandXboxController commandXboxController) {
    this.intakeSubsytem = intakeSubsytem;
    this.loadingSubsystem = loadingSubsystem;
    this.commandXboxController = commandXboxController;
    addRequirements(intakeSubsytem);
    addRequirements(loadingSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsytem.coast();
    loadingSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsytem.setSpeed(commandXboxController.getLeftY());
    loadingSubsystem.setSpeed(commandXboxController.getRightX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsytem.brake();
    loadingSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
