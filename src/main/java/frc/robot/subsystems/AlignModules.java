// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;

public class AlignModules extends Command {
  /** Creates a new AlignModules. */
  private TurnMotorSubsystem turnMotorSubsystem;
  private PIDController[] pidControllers;

  public AlignModules(TurnMotorSubsystem turnMotorSubsystem) {
    this.turnMotorSubsystem = turnMotorSubsystem;
    pidControllers = new PIDController[turnMotorSubsystem.getNumMotors()];
    addRequirements(turnMotorSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    for (int i = 0; i < turnMotorSubsystem.getNumMotors(); i++) {
      pidControllers[i] = new PIDController(0.2, 0, 0);
      pidControllers[i].setSetpoint(turnMotorSubsystem.getOffsets()[i]);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    for (int i = 0; i < turnMotorSubsystem.getNumMotors(); i++) {
      TalonFX motor = turnMotorSubsystem.getMotors()[i];
      PIDController pidController = pidControllers[i];
      double position = turnMotorSubsystem.getEncoders()[i].getAbsolutePosition().getValueAsDouble();
      motor.set(
        pidController.calculate(position)
      );
    }
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
