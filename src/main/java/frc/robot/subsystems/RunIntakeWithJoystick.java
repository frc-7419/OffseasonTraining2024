// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RunIntakeWithJoystick extends Command {
  /** Creates a new RunIntakeWithJoystick. */
  private final IntakeSubsystem intakeSubsystem;
  private final CommandXboxController joystick;

  public RunIntakeWithJoystick(IntakeSubsystem intakeSubsystem, CommandXboxController joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intakeSubsystem = intakeSubsystem;
    this.joystick = joystick;
    addRequirements(intakeSubsystem);

    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.coast();
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (joystick.getRightTriggerAxis() > 0.05) {
      intakeSubsystem.set(0.5);

    }
    else{
      intakeSubsystem.set(0);
      intakeSubsystem.brake();
    }
    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.set(0);
    intakeSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
