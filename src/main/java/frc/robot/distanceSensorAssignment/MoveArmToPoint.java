// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.distanceSensorAssignment;

import java.util.Set;

import com.revrobotics.Rev2mDistanceSensor;
import com.revrobotics.Rev2mDistanceSensor.Port;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ArmSubsystem;

public class MoveArmToPoint extends Command {
  private final PIDController pidController = new PIDController(1.5, 0, 0.5);
  private final ArmFeedforward armFeedforward = new ArmFeedforward(1, 0.5, 0.1);
  private double setPoint;
  private final Rev2mDistanceSensor distMXP;
  private final ArmSubsystem armSubsystem;
  public MoveArmToPoint(double setPoint, ArmSubsystem armSubsystem) {
   this.setPoint = setPoint;
   this.armSubsystem = armSubsystem;
   this.distMXP = new Rev2mDistanceSensor(Port.kMXP);
   addRequirements(armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast();
    pidController.setSetpoint(setPoint);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double currentPos = armSubsystem.getPosition();
    double pid = pidController.calculate(currentPos);
    double ff = armFeedforward.calculate(currentPos,2);
    if (distMXP.getRange()>=0.3) { //prevents arm from slamming into a wall or other gameobject
      armSubsystem.runMotor(pid+ff);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }
}
