// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.AssessmentOnePractice.commands;
import com.ctre.phoenix6.controls.compound.Diff_VelocityDutyCycle_Position;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.AssessmentOnePractice.subsystems.DriveBaseSubsystem;
import edu.wpi.first.wpilibj.XboxController;


public class TankDrive extends CommandBase {
  private DriveBaseSubsystem driveBaseSubsystem;
  private XboxController xboxController;
  /** Creates a new ArcadeDrive. */
  public TankDrive(DriveBaseSubsystem driveBaseSubsystem, XboxController xboxController) {
    this.driveBaseSubsystem = driveBaseSubsystem;
    this.xboxController = xboxController;
    // Use addRequirements() here to declare subsystem dependencies.
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveBaseSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double move = 0.7 * -xboxController.getLeftY();
    double turn = 0.7* xboxController.getRightX();
    driveBaseSubsystem.runMotor(move+turn,move-turn);
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
