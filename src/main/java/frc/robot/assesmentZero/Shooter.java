// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assesmentZero;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Shooter extends Command {
  /** Creates a new Shooter. */
  private final CommandXboxController joystickCommandXboxController;
  private final ShooterSubsystem shooterMotorShooterSubsystem;
  private final ShooterSubsystem topMotorShooterSubsystem;
  private final ShooterSubsystem bottomMotorShooterSubsystem;
  private final JoystickButton buttonJoystickButton;
  //the up does the button idk how to import it or do it cuz we never went over it

  public Shooter(ShooterSubsystem shooterMotor, CommandXboxController joystickCommandXboxController, ShooterSubsystem topMotor, ShooterSubsystem bottomMotor, JoystickButton buttonJoystickButton) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterMotorShooterSubsystem = shooterMotor;
    this.joystickCommandXboxController = joystickCommandXboxController;
    this.bottomMotorShooterSubsystem = bottomMotor;
    this.topMotorShooterSubsystem = topMotor;
    this.buttonJoystickButton = buttonJoystickButton;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterMotor.coastMotor();
    topMotor.coastMotor();
    bottomMotor.coastMotor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterMotor.setPower(joystickCommandXboxController.getLeftY());
    topMotor.setPower(JoystickButton.buttonJoystickButton);
    bottomMotor.setPower(JoystickButton.buttonJoystickButton);
    //Don't know how to tell when pressed
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterMotor.brakeMotor();
    topMotor.brakeMotor();
    bottomMotor.brakeMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
