// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.makeUpAssessmentZero;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

public class PickUpNote extends Command {
  /** Creates a new IntakeSubsystem. */
  private IntakeSubsystem intake;
  private LoaderSubsystem loader;
  public PickUpNote() {
    intake = new IntakeSubsystem();
    loader = new LoaderSubsystem();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (intake.isButtonPressed()) {
      intake.setMotorSpeed(1);
      SmartDashboard.putBoolean("intakeIsRunning", true);
    } else {
      intake.setMotorSpeed(0);
      SmartDashboard.putBoolean("intakeIsRunning", false);
    }
    if (loader.isButtonPressed()) {
      loader.setMotorSpeed(1);
      SmartDashboard.putBoolean("loaderIsRunning", true);
    } else {
      loader.setMotorSpeed(0);
      SmartDashboard.putBoolean("loaderIsRunning", false);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
