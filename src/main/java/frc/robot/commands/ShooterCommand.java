// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.XboxController;
public class ShooterCommand extends CommandBase {
    private final ShooterSubsystem shooterSubsystem;
    //no need to restate the motors in the subsystem
    private final XboxController xBoxController;
    public ShooterCommand(ShooterSubsystem shooterSubsystem){
        this.shooterSubsystem = shooterSubsystem;
        this.xBoxController = new XboxController(0);

    }
    @Override
    public void initialize() {
      shooterSubsystem.coast();
      //test it out and pray
      
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      shooterSubsystem.runShooter(xBoxController.getLeftY());
      
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
