// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class PIDthings extends Command {
  PIDController pidController = new PIDController(0, 0, 0);
  ArmFeedforward feedforward = new ArmFeedforward(0, 0, 0);
  private final ArmSubsystem armSubsystem;
  public final double setpos;
  /** Creates a new PIDthings. */
  public PIDthings(double setpos) {
    this.setpos = setpos;
    this.armSubsystem = new ArmSubsystem();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
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
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
