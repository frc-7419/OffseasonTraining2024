// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ArmConstants;

public class ArmToSetpoint extends Command {
  ArmSubsystem armSubsystem;
  double setpoint;
  PIDController pidController = new PIDController(0.9, 0.1, 0.9);
  ArmFeedforward armFeedforward = new ArmFeedforward(0.9, 0.1, 0.9);
  /** Creates a new ArmToSetpoint. */
  public ArmToSetpoint(ArmSubsystem armSubsystem, double setpoint) {
    this.armSubsystem = armSubsystem;
    this.setpoint = setpoint;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast();
    armSubsystem.runMotor(0);
    pidController.setSetpoint(setpoint);
    pidController.setTolerance(ArmConstants.setpointThreshold);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double position = armSubsystem.getPosition();
    armSubsystem.runMotor(armFeedforward.calculate(position, setpoint) * pidController.calculate(position));
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
