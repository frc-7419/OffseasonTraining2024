// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


//*Imports the required packages for running the angle and revving motors */
package frc.robot.assessmentZero;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

//* Command that sets the motor launcher to a certain angle and starts to rev the motors. */
public class ShooterCommandV2 extends Command {
  /** Creates a new ShooterCommand. */
  //* Declares the variable needed */
  private final CommandXboxController joystick;
  private final ShooterSubsystem shooterSubsystem;
  //* Defines the variables */
  public ShooterCommandV2(ShooterSubsystemV2 shooterSubsystemV2) {
    this.shooterSubsystem = shooterSubsystemV2;
    addRequirements(shooterSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  //* Sets all the motors to coast mode */
  @Override
  public void initialize() {
    shooterSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  //* Checks whether the bumper is pressed --> If yes then rev the motor */
  //* Also sets the angle of the motor based on the left joystick y */
  @Override
  public void execute() {
    shooterSubsystem.setPower(0.9);
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
