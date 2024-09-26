// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZeroSol;

import edu.wpi.first.units.Power;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RunShooterCommand extends Command {
  
  private final ShooterSubsystem shooterSubsystem;
  private final CommandXboxController joystick;
  private final double power;

  public RunShooterCommand(ShooterSubsystem shooterSubsystem, CommandXboxController joystick, double power) {
    this.shooterSubsystem = shooterSubsystem;
    this.joystick = joystick; 
    this.power = power;
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.runShooter(joystick.a().getAsBoolean()?power:0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.brake(); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
