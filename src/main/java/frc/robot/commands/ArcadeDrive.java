// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveBaseSubsystem;

public class ArcadeDrive extends Command {

  private final DriveBaseSubsystem driveBaseSubsystem;
  private final XboxController xboxController;

  public ArcadeDrive(DriveBaseSubsystem driveBaseSubsystem, XboxController xboxController) {
    this.driveBaseSubsystem = driveBaseSubsystem;
    this.xboxController = xboxController;
    addRequirements(driveBaseSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double forward = -xboxController.getLeftY();
    double rotation = xboxController.getRightX();
    forward *= 0.5;
    rotation *= 0.5;

    driveBaseSubsystem.setPower(forward + rotation, forward - rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBaseSubsystem.setPower(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
