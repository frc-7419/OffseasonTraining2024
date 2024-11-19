// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivebaseSubsystem;

public class SetSwerveSpeed extends Command {
  Boolean done = false;
  double s, r
  DrivebaseSubsystem d;
  /** Creates a new SetSwerveSpeed. */
  public SetSwerveSpeed(DrivebaseSubsystem drivebase, double speed, double rotation) {
    s = speed;
    r = rotation;
    d = drivebase;
    addRequirements(drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    d.setPower(s+r, s-r);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
