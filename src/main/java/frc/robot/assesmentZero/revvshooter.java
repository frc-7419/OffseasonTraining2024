// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assesmentZero;

import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class revvshooter extends Command {
  private final shootersunsystem shooterSubsystem;
  private final CommandXboxController button;

  /** Creates a new revvshooter. */
  public revvshooter(shootersunsystem shooterSubsystem, CommandXboxController button) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterSubsystem = shooterSubsystem;
    this.button = button;
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSubsystem.coastShooterMotor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.setPowerShooterMotor //use some button
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.brakeShooterMotor();

  // Returns true when the command should end.
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
