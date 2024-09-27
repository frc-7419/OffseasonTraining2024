// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ArmFeedforward;

public class SetArmToPoint extends Command {
  public final ArmSubsytem armSubsystem;
  private double setpoint;
  private final PIDController pidController = new PIDController(1.0, 0.0, 0.1);
  private final ArmFeedforward armFeedforward = new ArmFeedforward(setpoint, setpoint, setpoint)

  /** Creates a new PIDCommand. */
  public SetArmToPoint(ArmSubsystem armSubsystem, double setpoint) {
    this.armSubsystem = armSubsystem;
    this.setpoint = setPoint;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast();
    armSubsystem.setPower(0);
    pidController.setTolerance(5,10);
    pidController.setSetpoint(setPoint);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double currentPosition = armSubsystem.getPosition();
    double ff = armFeedforward.calculate(currentPosition, 5);
    double pidValue = pidController.calculate(currentPosition);
    double armSubsystem.setPower(pidValue+ff);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.setPower(0);
    armSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return PIDController.setPoint();
    return false;
  }
}
