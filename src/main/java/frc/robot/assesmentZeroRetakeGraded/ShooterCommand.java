// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assesmentZeroRetakeGraded;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class ShooterCommand extends Command {
  /** Creates a new BrehCommand. */
  private final CommandXboxController joystick;
  private final ShooterSubsystem shooterSubsystem;
  private final IntakeSubsystem intakeSubsystem; 
  public ShooterCommand(IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem, CommandXboxController joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.joystick = joystick;
    this.intakeSubsystem = intakeSubsystem;
    this.shooterSubsystem = shooterSubsystem;
    addRequirements(intakeSubsystem, shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.coastTheIntakeMotor();
    shooterSubsystem.coastTheMotor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.setPower(joystick.getLeftY());
    if (joystick.leftBumper().getAsBoolean()) {
      shooterSubsystem.setThePower(0.9);
    } else {
      shooterSubsystem.setThePower(0.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.brakeTheIntakeMotor();
    shooterSubsystem.brakeTheMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
