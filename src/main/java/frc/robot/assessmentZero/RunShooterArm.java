// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assessmentZero;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class RunShooterArm extends Command {
  //setting up xboxcontroller and shootersubsystem
  private final XboxController xboxController;
  private final ShooterSubsystem shooterSubsystem; 
  public RunShooterArm(ShooterSubsystem shooterSubsystem, XboxController xboxController) {
    this.shooterSubsystem = shooterSubsystem;
    this.xboxController = xboxController;
    //Constructor for the runShooterArm command
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSubsystem.coastShooterArm();
    shooterSubsystem.coastRevShooterMotors();
    //coasts both shooter motors and shootor arm motor
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.moveShooterArm(xboxController.getLeftY()); // turn arm motor
    if (xboxController.getAButtonPressed()) { // turn rev motors
      shooterSubsystem.revShooterMotor();
    }else{
      shooterSubsystem.brakeRevShooterMotors();;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //when command ends, brake all motors
    
    shooterSubsystem.brakeRevShooterMotors();
    shooterSubsystem.brakeShooterArm();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
