// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.makeUpAssessmentZero;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

public class RunIntakeLoader extends Command {
  private final Joystick joystick;
  private final IntakeLoaderSubsystem intakeLoaderSubsystem;

  public RunIntakeLoader(Joystick joystick, IntakeLoaderSubsystem intakeLoaderSubsystem) {
    this.joystick = joystick;
    this.intakeLoaderSubsystem = intakeLoaderSubsystem;
    addRequirements(intakeLoaderSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeLoaderSubsystem.IntakeCoast();
    intakeLoaderSubsystem.LoaderCoast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double intakeSpeed = joystick.getY();

    if (Math.abs(intakeSpeed) > 0) {
      intakeLoaderSubsystem.setIntakeSpeed(intakeSpeed);
    } else {
      intakeLoaderSubsystem.IntakeBrake();
    }

    if (joystick.getRawButton(1)) {
      intakeLoaderSubsystem.setLoaderSpeed(1);
    } else {
      intakeLoaderSubsystem.LoaderBrake();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeLoaderSubsystem.IntakeBrake();
    intakeLoaderSubsystem.LoaderBrake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
