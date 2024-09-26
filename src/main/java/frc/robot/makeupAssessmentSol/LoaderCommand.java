// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.makeupAssessmentSol;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class LoaderCommand extends Command {

  private final LoaderSubsystem loaderSubsystem;
  private final double power; 
  private final CommandXboxController joystick; 

  public LoaderCommand(LoaderSubsystem loaderSubsystem, double power, CommandXboxController joystick) {
    this.loaderSubsystem = loaderSubsystem;
    this.power = power;
    this.joystick = joystick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    loaderSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    loaderSubsystem.runLoader(joystick.rightBumper().getAsBoolean()?power:0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    loaderSubsystem.brake();
    loaderSubsystem.runLoader(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
