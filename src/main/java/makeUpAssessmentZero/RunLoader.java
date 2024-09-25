// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package makeUpAssessmentZero;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class RunLoader extends Command {
  /** Creates a new RunLoader. */
  private final LoaderSubsystem loaderSubsystem;
  private final XboxController xboxController;
  public RunLoader() {
    this.loaderSubsystem = new LoaderSubsystem(1);
    this.xboxController = new XboxController(0);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    loaderSubsystem.CoastLoader();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if (xboxController.getBButtonPressed()){
        loaderSubsystem.RunLoader();
      }
      else{
        loaderSubsystem.BrakeLoader();
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    loaderSubsystem.BrakeLoader();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
