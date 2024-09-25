// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package assessmentZeroPartTwo;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class ControlShooterWithJoystick extends Command {
  /** Creates a new ControlShooterWithJoystick. */
  private final ShooterRevSubsystem shooterSubsystem;
  private final ShooterAngleSubsystem shooterAngleSubsystem;
  private final XboxController xboxController;
  public ControlShooterWithJoystick() {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterSubsystem = new ShooterRevSubsystem();
    this.xboxController = new XboxController(0);
    this.shooterAngleSubsystem = new ShooterAngleSubsystem();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (xboxController.getAButtonPressed()){
      shooterSubsystem.RevShooter(1);
    }
    else{
      shooterSubsystem.BrakeShooter();
    }
    shooterAngleSubsystem.AngleShooter(xboxController.getLeftY(), false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
