// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class RunArm extends Command {
  /** Creates a new RunArm. */
  private final ArmSubsystem armSubsystem;

  //This two lines of code initialize the PID and Feedforward
  private double setpoint;
  private final PIDController pidController = new PIDController(3, 0, 1);
  private final ArmFeedforward armFeedforward = new ArmFeedforward(0, 0, 0);

  public RunArm(ArmSubsystem armSubsystem, double setpoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.armSubsystem = armSubsystem;
    this.setpoint = setpoint;
    addRequirements(armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast();
    armSubsystem.runMotor(0);
    pidController.setSetpoint(setpoint);
    pidController.setTolerance(0.01, 0.1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    armSubsystem.runMotor(armFeedforward.calculate(armSubsystem.getPosition(), armSubsystem.getVelocity()) + pidController.calculate(setpoint));
  }

  // Called once the command ends or is interrupted. 
  @Override
  public void end(boolean interrupted) {
    armSubsystem.runMotor(0);
    armSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }
}
