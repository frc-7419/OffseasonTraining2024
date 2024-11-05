// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.AlignModules;
import frc.robot.subsystems.TurnMotorSubsystem;

public class RobotContainer {
  
  private final CommandXboxController driveJoystick = new CommandXboxController(Constants.Operator.kdriveControllerPort);
  private final TurnMotorSubsystem turnMotorSubsystem = new TurnMotorSubsystem();
  private AlignModules alignModules = new AlignModules(turnMotorSubsystem);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    driveJoystick.rightBumper().getAsBoolean();
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
  public void setDefaultCommands() {
    // turnMotorSubsystem.setDefaultCommand(alignModules);
  }
}
