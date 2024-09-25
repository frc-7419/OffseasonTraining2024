// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class SetArmToPoint extends Command {
  PIDController pidController = new PIDController(1.0, 0.0, 0.1);
  ArmFeedforward feedforward = new ArmFeedforward(0.0, 1.0, 0.5,0.1);
  private final ArmSubsystem armSubsystem;
  public final double setpos;
  /** Creates a new PIDthings. */
  public SetArmToPoint(double setpos, ArmSubsystem armSubsystem) {
    this.setpos = setpos;
    this.armSubsystem = armSubsystem;
    addRequirements(armSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast();
    armSubsystem.runMotor(0, false);
    pidController.setSetpoint(setpos);
    pidController.setTolerance(5, 10);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double pos = armSubsystem.getPosition();
    double ff = feedforward.calculate(pos, setpos);
    armSubsystem.runMotor(ff + pidController.calculate(pos), false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.runMotor(0, false);
    armSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }
}
