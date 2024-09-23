// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class FireProjectile extends Command {
  /** Creates a new FireProjectile. */
  private ProjectileFirer myProjectileFirer;
  public FireProjectile() {
    // Use addRequirements() here to declare subsystem dependencies.
    myProjectileFirer = new ProjectileFirer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.

  //This function sets the angle first
  @Override
  public void execute() {
    //Sets up the proper angle
    myProjectileFirer.setAngle();
    //Speeds up the flywheel motor
    myProjectileFirer.setFlywheelSpeed(1);
    //Gives some time for the projectile to fly out
    wait(50);
    //Stops the motors
    myProjectileFirer.setFlywheelSpeed(0);
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
