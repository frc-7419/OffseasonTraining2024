// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class RunArmToPosition extends Command {
  /** Creates a new RunArmSubsystem. */
  private ArmSubsystem arm;
  private double goal;
  private PIDController pid;
  private ArmFeedforward ff;
  public RunArmToPosition(ArmSubsystem myArm, double goal) {
    // Use addRequirements() here to declare subsystem d
    arm = myArm;
    this.goal = goal;
    addRequirements(arm);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.coast();
    arm.setSpeed(0);
    pid = new PIDController(0.5, 0, 0.1);
    pid.setSetpoint(goal);
    pid.setTolerance(0.1, 0.1);
    ff = new ArmFeedforward(0, 1, 0.1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double position = arm.getPosition();
    arm.setSpeed(pid.calculate(position) + ff.calculate(position, arm.getVelocity()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.setSpeed(0);
    arm.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pid.atSetpoint();
  }
}
