// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessment0;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RunShooter extends Command {
  /** Creates a new RunShooter. */
  private final ShooterSubsystem shooterSubsystem;
  private final CommandXboxController controller;
  public RunShooter() {
    shooterSubsystem = new ShooterSubsystem();
    controller = new CommandXboxController(0);
    addRequirements(shooterSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSubsystem.coast();
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // get the angle of the shooter using the left stick's y axis
    double angle = controller.getLeftY();
    // run the shoooter at full power while the right trigger is pressed
    if (controller.getRightTriggerAxis() > 0.5) {
      shooterSubsystem.setAngle(angle);
      shooterSubsystem.setPower(1);
    } else {
      shooterSubsystem.brakeShooter();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
