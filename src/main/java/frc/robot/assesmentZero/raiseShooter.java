// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assesmentZero;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ArmSubsystem;

public class raiseShooter extends Command {


  /** Creates a new raiseShooter. */
private final shootersubsystem shooterSubsystem;
private final CommandXboxController joystick;

public raiseShooter (shootersubsystem shooterSubsystem, CommandXboxController joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    
  this.shooterSubsystem = shooterSubystem; 
  this.joystick = joystick;
      

  addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSubsystem.coastArmRaiseMotor();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    armSubystem.setArmRaiseMotorPower(joystick.rightBumper());


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    shooterSubsystem.brakeArmRaiseMotor();


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
