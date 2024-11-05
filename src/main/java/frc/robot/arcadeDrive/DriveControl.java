// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveControl extends Command {
  private final arcadeDriveSubsystem arcadeDrive;
  private final XboxController xboxController;
  private double motorPower = 0;
  private double turnPower = 0;

  public DriveControl(arcadeDriveSubsystem arcadeDrive,XboxController xboxController) {
    this.arcadeDrive = arcadeDrive;
    this.xboxController = xboxController;
   addRequirements(arcadeDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      motorPower = 0;
      turnPower = 0;
      arcadeDrive.setPower(0, 0);
      arcadeDrive.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motorPower = xboxController.getLeftX();
    turnPower = xboxController.getRightY();
    if (Math.abs(xboxController.getLeftX())>=0.04) arcadeDrive.setPower(motorPower,motorPower);
    if (Math.abs(xboxController.getRightY())>=0.04) arcadeDrive.setPower(turnPower, -turnPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arcadeDrive.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
