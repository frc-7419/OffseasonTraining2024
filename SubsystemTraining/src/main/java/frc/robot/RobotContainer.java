// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.arm.ArmSubsystem;
import frc.robot.subsystems.arm.RunArmWithJoystick;

public class RobotContainer {
  private CommandXboxController driver = new CommandXboxController(0);
  private ArmSubsystem armSubsystem = new ArmSubsystem();
  private RunArmWithJoystick runArmWithJoystick = new RunArmWithJoystick(driver, armSubsystem);
  
  public RobotContainer() {
    configureBindings();
    setDefaultCommands();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  public void setDefaultCommands() {
    armSubsystem.setDefaultCommand(runArmWithJoystick);
  }
}
