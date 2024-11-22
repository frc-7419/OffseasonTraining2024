// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ArmSubsystem;

public class RunArmWithJoystick extends Command {
  /** Creates a new RunArmWithJoystick. */
  private final ArmSubsystem armSubsystem;
  private final CommandXboxController joystick;

  public RunArmWithJoystick(ArmSubsystem armSubsystem, CommandXboxController joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.armSubsystem = armSubsystem;
    this.joystick = joystick;
    addRequirements(armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      armSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (joystick.getRightY() > 0.1) {
      armSubsystem.setVoltage(joystick.getRightY());
    }
    else if (joystick.getRightY() < -0.1) {
      armSubsystem.setVoltage(joystick.getRightY());
    }
    else {
      armSubsystem.setVoltage(0);
      armSubsystem.brake();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.setVoltage(0);
    armSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
