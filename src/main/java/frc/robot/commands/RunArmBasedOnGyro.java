// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class RunArmBasedOnGyro extends Command {
  GyroSubsystem gyroSubsystem;
  ArmSubsystem armSubsystem;
  /** Creates a new RunArmBasedOnGyro. */
  public RunArmBasedOnGyro(GyroSubsystem gyroSubsystem, ArmSubsystem armSubsystem) {
    this.gyroSubsystem = gyroSubsystem;
    this.armSubsystem = armSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(gyroSubsystem, armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (gyroSubsystem.yawAHRS() < 45) {
      armSubsystem.runMotor(0.5); // some random goofy thing ig just for fun
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.runMotor(0);
    armSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
