// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.DriveBaseSubsystem;
import frc.robot.Subsystems.drive.ArcadeDriveBaseSubsystem;
import frc.robot.subsystems.DriveBaseSubsystem;

public class ArcadeDrive extends Command {

  private final ArcadeDriveBaseSubsystem arcadeDriveBaseSubsystem;
  private final XboxController xboxController;

  public ArcadeDrive(ArcadeDriveBaseSubsystem arcadeDriveBaseSubsystem) {
    this.arcadeDriveBaseSubsystem = arcadeDriveBaseSubsystem;
    this.xboxController = xboxController;
    addRequirements(arcadeDriveBaseSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double forward = -controller.getLeftY();
    double rotation = controller.getRightX();
    forward *= 0.5;
    rotation *= 0.5;

    arcadeDriveBaseSubsystem.setPower(forward + rotation, forward - rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arcadeDriveBaseSubsystem.setPower(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

/* 
 package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;

public class ArcadeDrive extends CommandBase {

    private final DriveBaseSubsystem driveBaseSubsystem;
    private final XboxController controller;

    public ArcadeDrive(DriveBaseSubsystem driveBaseSubsystem, XboxController controller) {
        this.driveBaseSubsystem = driveBaseSubsystem;
        this.controller = controller;
        addRequirements(driveBaseSubsystem);
    }

    @Override
    public void execute() {
        double forward = -controller.getLeftY();
        double rotation = controller.getRightX();
        forward *= 0.5;
        rotation *= 0.5;

        driveBaseSubsystem.setPower(forward + rotation, forward - rotation);
    }

    @Override
    public void end(boolean interrupted) {
        driveBaseSubsystem.setPower(0, 0);
    }
}

 */