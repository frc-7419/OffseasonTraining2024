// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.MakeUpAssessment0;

import edu.wpi.first.wpilibj2.command.Command;

public class RunLoader extends Command {
  /** Creates a new RunLoader. */
  private final LoaderSubSystem loaderMotor1;
  private final LoaderSubSystem loaderMotor2;
  private final CommandXboxController joystick;
  public RunLoader() {
    // Use addRequirements() here to declare subsystem dependencies.
    this.CommandXboxController.joystick = joystick;
    this.loaderMotor1 = loaderMotor1;
    this.loaderMotor2 = loaderMotor2
    addRequirements(LoaderSubSystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    loaderMotor1.coast()
    loaderMotor2.coast()
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    loaderMotor1.runMotor(joystick.getRightY())
    loaderMotor2.runMotor(joystick.getRightY())
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if joystick.getLeftBumper().getAsBoolean()
    loaderMotor1.brake()
    loaderMotor2.brake()

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
