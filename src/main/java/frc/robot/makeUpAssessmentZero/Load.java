// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.makeUpAssessmentZero;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Load extends Command {
  private final LoaderSubsystem loader;
  private final double power;
  private final CommandXboxController joystick;
  public Load(LoaderSubsystem loader, double power, CommandXboxController joystick) {
    this.loader = loader;
    this.power = power;
    this.joystick = joystick;
    addRequirements(loader);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    loader.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    loader.runLoader(joystick.rightBumper().getAsBoolean()?power:0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    loader.brake();
    loader.runLoader(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
