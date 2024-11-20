// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.SwerveDrivebase;

public class DriveSwerveRobot extends Command {
  private final XboxController xboxController;
  private final SwerveDrivebase swerveDrivebase;
  public DriveSwerveRobot(XboxController xboxController, SwerveDrivebase swerveDrivebase) {
    this.xboxController = xboxController;
    this.swerveDrivebase = swerveDrivebase;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(swerveDrivebase);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    swerveDrivebase.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    swerveDrivebase.setSwerveModuleStateWithChassisSpeeds(swerveDrivebase.getChassisSpeedsFromControllerInput(xboxController.getLeftX(), xboxController.getLeftY(), xboxController.getRightX()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    swerveDrivebase.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
