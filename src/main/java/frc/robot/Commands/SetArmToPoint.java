// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ArmSubsystem;

public class SetArmToPoint extends Command {
  private final PIDController pidController = new PIDController(1.0,0.0,0.0);
  private double setPoint;
  private final ArmSubsystem armSubsystem;
  private final ArmFeedforward armFeedforward = new ArmFeedforward(0.0,1.0,0.5,0.1);
  public SetArmToPoint(ArmSubsystem armSubsystem, double setPoint) {
    this.armSubsystem = armSubsystem;
    this.setPoint = setPoint;
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
    double ff = armFeedforward.calculate(currentPosition,setPoint);
    armSubsystem.setPower(ff + pidController.calculate(currentPosition));

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
    return pidController.atSetpoint();
  }
}
