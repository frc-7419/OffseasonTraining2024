// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivebaseSubsystem;

public class ArcadeDrive extends Command {
  /** Creates a new ArcadeDrive. */
  private DrivebaseSubsystem drivebase;
  private XboxController controller;
  public ArcadeDrive(DrivebaseSubsystem drivebase) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivebase = drivebase;
    addRequirements(drivebase);
    this.controller = new XboxController(1);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forwardsMovement = -controller.getLeftY();
    double rotation = controller.getLeftX();
    drivebase.setPower((forwardsMovement + rotation) / 2, (forwardsMovement - rotation) / 2);
  } 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
