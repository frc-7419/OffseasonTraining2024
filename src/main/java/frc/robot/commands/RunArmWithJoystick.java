// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.subsystems.ArmSubsystem;

public class RunArmWithJoystick extends Command {

  private final ArmSubsystem arm;
  private final CommandXboxController joystick;

  public RunArmWithJoystick(ArmSubsystem armSubsystem, CommandXboxController joystick) {
    this.armSubsystem = arm;
    this.joystick = joystick;
    addRequirements(arm);
  }

  @Override
  public void initialize() {
    arm.coast();
  }

  @Override
  public void execute() {
    arm.runMotor(joystick.getLeftY());
    
    if (joystick.leftBumper().getAsBoolean()) {
      arm.runMotor(0.5);
    }
  }

  @Override
  public void end(boolean interrupted) {
    arm.brake();
  }

  @Override
  public boolean isFinished() {
    return false; 
  }
}