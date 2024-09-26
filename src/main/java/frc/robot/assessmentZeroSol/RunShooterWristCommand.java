// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZeroSol;

import edu.wpi.first.units.Power;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RunShooterWristCommand extends Command {

  private final ShooterWristSubsystem shooterWristSubsystem;
  private final CommandXboxController joystick;

  public RunShooterWristCommand(ShooterWristSubsystem shooterWristSubsystem, CommandXboxController joystick) {
    this.shooterWristSubsystem = shooterWristSubsystem;
    this.joystick = joystick;
    addRequirements(shooterWristSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterWristSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterWristSubsystem.moveWrist(joystick.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterWristSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
