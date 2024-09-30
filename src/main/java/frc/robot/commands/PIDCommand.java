// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ArmToSetpoint extends CommandBase {
  private final ArmSubsystem armSubsystem;
  private final double setpoint; 
  private final PIDController pidController = new PIDController(0.9, 0.1, 0.9);
  private final ArmFeedforward armFeedforward = new ArmFeedforward(0.9, 0.1, 0.9);
  
  //instantiates armSubsystem & setpoint
  public ArmToSetpoint(ArmSubsystem armSubsystem, double setpoint) {
    this.armSubsystem = armSubsystem;
    this.setpoint = setpoint;
    addRequirements(armSubsystem);
  }
  
  @Override
  public void initialize() {
    armSubsystem.coast();
    armSubsystem.runMotor(0);
    pidController.setSetpoint(setpoint);
    pidController.setTolerance(1.0);  
  }
  @Override
  public void execute() {
    double position = armSubsystem.getPosition();
    double output = armFeedforward.calculate(position, setpoint) + pidController.calculate(position);
    armSubsystem.runMotor(output);
  }
  @Override
  public void end(boolean interrupted) {
    armSubsystem.runMotor(0);
    armSubsystem.brake();
  }
  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }
}
