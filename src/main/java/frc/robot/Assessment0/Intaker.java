// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Assessment0;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class Intaker extends Command {
  XboxController xboxController;
  IntakeSubsystem intake;
  LoaderSubsystem loader;
  boolean intaking = false;
  boolean loading = false;
  /** Creates a new Intaker. */
  public Intaker(IntakeSubsystem intake, LoaderSubsystem loader, XboxController xboxController) {
    this.xboxController = xboxController;
    this.intake = intake;
    this.loader = loader;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake, loader);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.Coast();
    loader.Coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (xboxController.getAButtonPressed()) {
      if (intaking) {
        intaking = false;
        intake.setSpeed(0);
      } else {
        intaking = true;
        intake.setSpeed(1);
      }
    }

    if (xboxController.getBButtonPressed()) {
      if (loading) {
        loading = false;
        loader.setSpeed(0);
      } else {
        loading = true;
        loader.setSpeed(1);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.setSpeed(0);
    loader.setSpeed(0);
    intake.Brake();
    loader.Brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
