// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.fasterxml.jackson.core.sym.Name;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.RunArmWithJoystick;
import frc.robot.Commands.RunShooterDuringAuton;
import frc.robot.Subsystems.ArcadeDrive;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;
import frc.robot.Subsystems.ArmSubsystem;

public class RobotContainer {
  private final ArcadeDrive arcadeDrive = new ArcadeDrive();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final Command runIntake = new RunCommand(() -> intakeSubsystem.runIntake(0.9), intakeSubsystem);
  private final RunShooterDuringAuton runShooterDuringAuton = new RunShooterDuringAuton(shooterSubsystem);

  private final PathPlannerAuto twoNoteAuton = new PathPlannerAuto("TwoNoteAuton");

  public RobotContainer() {
    configureBindings();
    configureNamedCommandsPathPlanner();
  }

  private void configureBindings() {

  }
  private void configureNamedCommandsPathPlanner(){
    NamedCommands.registerCommand("Shoot", runShooterDuringAuton);
    NamedCommands.registerCommand("Intake", runIntake);
  }
  public Command getAutonomousCommand() {
    return twoNoteAuton;
  }
  
}
