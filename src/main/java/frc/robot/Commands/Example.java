// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.ExampleSubsystem;

public class Example extends Command {

  private final ExampleSubsystem exampleSubsystem;
  private final CommandXboxController joystick;

  public Example(ExampleSubsystem exampleSubsystem, CommandXboxController joystick) {
    this.exampleSubsystem = exampleSubsystem;
    this.joystick = joystick;
    addRequirements(exampleSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    exampleSubsystem.coast();
  }

  @Override
  public void execute() {
    exampleSubsystem.runMotor(joystick.getLeftY(), joystick.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    exampleSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
