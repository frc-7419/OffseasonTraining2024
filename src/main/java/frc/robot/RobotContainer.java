// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.assesmentZeroRetakeGraded.IntakeSubsystem;
import frc.robot.assesmentZeroRetakeGraded.ShooterCommand;
import frc.robot.assesmentZeroRetakeGraded.ShooterSubsystem;
import frc.robot.commands.RunArm;
import frc.robot.subsystems.ArmSubsystem;

public class RobotContainer {
  
  private final CommandXboxController driveJoystick = new CommandXboxController(Constants.Operator.kdriveControllerPort);
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final ShooterCommand shooterCommand = new ShooterCommand(intake, shooter, driveJoystick);
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  private final RunArm runArm = new RunArm(armSubsystem, 0.117);
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  private void setDefaultCommands() {
    shooter.setDefaultCommand(shooterCommand);
    intake.setDefaultCommand(shooterCommand);
    driveJoystick.b().whileTrue(runArm);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
