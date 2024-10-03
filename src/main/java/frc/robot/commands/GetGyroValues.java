// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.GyroSubsystem;

public class GetGyroValues extends Command 
  private final GyroSubsystem gyroSubsystem;
  private final CommandXboxController commandXboxController;
  private final ArmSubsystem armSubsystem;


  /** Creates a new GetGyroValues. */
  public GetGyroValues(GyroSubsystem gyroSubsystem,CommandXboxController commandXboxController,ArmSubsystem armSubsystem) {
    this.gyroSubsystem = gyroSubsystem;
    this.commandXboxController = commandXboxController;
    this.armSubsystem = armSubsystem;

    addRequirements(gyroSubsystem, armSubsystem);

    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (gyroSubsystem.yaw()>= 20){
      armSubsystem.runMotor(0.5);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
