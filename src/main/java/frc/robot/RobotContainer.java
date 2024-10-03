// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.RunArmWithJoystick;
import frc.robot.subsystems.ArmSubsystem;

public class RobotContainer {
  
  private final ArmSubsystem armSubsystem = new ArmSubsystem();


  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    driveJoystick.rightBumper().getAsBoolean();
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}
