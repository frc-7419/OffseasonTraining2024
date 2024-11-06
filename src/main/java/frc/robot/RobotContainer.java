// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// import frc.robot.MakeUpAssessment0.RunIntake;
import frc.robot.subsystems.ArmSubSystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.RunIntakeWithJoystick;

public class RobotContainer {
  // private ArmSubSystem arm = new ArmSubSystem();
  private IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private CommandXboxController operatorJoystick = new CommandXboxController(0);
  private RunIntakeWithJoystick runIntakeWithJoystick = new RunIntakeWithJoystick(intakeSubsystem, operatorJoystick);
  
  public final CommandXboxController driveJoystick = new CommandXboxController(Constants.Operator.kdriveControllerPort);
  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    // driveJoystick.x().whileTrue(new SetArmSetpoint(arm, 180.0/360));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
    
  }
  public void setDefaultCommands(){
       intakeSubsystem.setDefaultCommand(runIntakeWithJoystick);
  }
}
