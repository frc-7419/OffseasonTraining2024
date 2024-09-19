// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class RunArm extends Command {
  /** Creates a new RunArm. */
  public RunArm() {
    private final ArmSubsystem arm;
    public RunArm(ArmSubsystem arm) {
      this.arm=arm;
      addRequirements(armSybsystem);

    }
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.runMotor
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) { 





    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
