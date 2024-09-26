// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.net.FileNameMap;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.TimeSyncEventData;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;
import pabeles.concurrency.ConcurrencyOps.NewInstance;

public class PidControl extends Command {
  private ArmSubsystem shooterWrist;
  private double setpoint;
  private final PIDController pidController = new PidController(1.0, 0.0 , 0.1);
  private final ArmFeedforward feedforward = new ArmFeedforward(0, 1, 0,1 );


  /** Creates a new PidControl. */
  public PidControl(ArmSubsystem shooterWrist, double setpoint) {
    this.shooterWrist = shooterWrist;
    this.setpoint = setpoint;
    addRequirements(shooterWrist);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterWrist.coast();
    shooterWrist.setPower(0);
    pidController.setSetpoint(setpoint);
    pidController.setTolerance(5, 10);
    }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double position = shooterWrist.getPosition();
    shooterWrist.setPower(feedforward.calculate(position, 2) + pidController.calculate(position));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterWrist.brake();
    shooterWrist.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }
}
