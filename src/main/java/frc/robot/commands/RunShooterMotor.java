// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class RunShooterMotor extends Command {
  /** Creates a new RunShooterMotor. */
  this.shooterSubSystem.shooterMotor0 = shooterMotor0;
  this.shooterSubSystem.shooterMotor0 = shooterMotor0;
  this.CommandXboxController.joystick = joystick;
  this.shooterSubSystem.angleMotor = angleMotor;
  this.CommandXboxController.rightBumper = rightBumper;
  this.CommandXboxController.rightY = rightY
  public RunShooterMotor() {
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterMotor0.coast();
    shooterMotor1.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterMotor0.runMotor(joystick.getValue());
    shooterMotor1.runMotor(joystick.getValue());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if interrupted{
      shooterMotor0.Brake();
      shooterMotor1.Brake();
    }
  }
  public void firingAngle(){
    angleMotor.runMotor(CommandXboxController.getRightY().getValue())


  }
  // Returns true when the command should end.
  public void rapidFire(){
    while(rightBumper.getValue().getAsBoolean())
      shooterMotor0.runMotor(1);
      shooterMotor1.runMotor(1);
      shooterMotor0.brake();
      shooterMotor0.brake();

  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
