// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.AssessmentZero;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class Shoot extends Command {
  private ShooterSubsystem shooterSubsystem;
  private XboxController xboxController;
  /** Creates a new Shoot. */
  public Shoot(ShooterSubsystem shooterSubsystem, XboxController xboxController) {
    this.shooterSubsystem = shooterSubsystem;
    this.xboxController = xboxController;
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
    double power = 0.5;
    if (xboxController.getYButtonPressed()) {
      shooterSubsystem.setPowerWheelMotor(power);
      SmartDashboard.putString("Shooter", "Wheels are spinning");
    }
    else {
      shooterSubsystem.stopMotor();
    }

    shooterSubsystem.setPower(xboxController.getRightY());
    SmartDashboard.putNumber("Shooter", xboxController.getRightY());



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.coast();
  }

  

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
