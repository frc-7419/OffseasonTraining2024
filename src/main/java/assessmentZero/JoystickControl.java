// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package assessmentZero;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class JoystickControl extends Command {
  public final ShooterSubsystem shooterAngle;
  public final ShooterSubsystem shooter0;
  public final ShooterSubsystem shooter1;
  public final XboxController xboxController;

  private final double deadzone;

  /** Creates a new JoystickControl. */
  public JoystickControl() {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterAngle = new ShooterSubsystem();
    this.xboxController = new XboxController(0);
    this.shooter0 = new ShooterSubsystem();
    this.shooter1 = new ShooterSubsystem();
    this.deadzone = 0.2;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (xboxController.getAButtonPressed()){
      shooter0.runMotor(1, false);
      shooter1.runMotor(1, false);
    }
    else{
      shooter0.brake();
      shooter1.brake();
    }

    if (xboxController.getLeftY() < -(deadzone)){
      shooterAngle.runMotor(0.5, true);
    }
    else if (xboxController.getLeftY() > (deadzone)){
      shooterAngle.runMotor(0.5, false);
    }
    else{
      shooterAngle.brake();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterAngle.brake();
    shooter0.brake();
    shooter1.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
