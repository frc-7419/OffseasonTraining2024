// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.AssessmentOnePractice.commands;
//USE PID CONTROLLER!
//Use ArmFeedForward -> Controller
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.AssessmentOnePractice.subsystems.ArmSubsystem;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;

public class SetArmtoPoint extends CommandBase {
  private final PIDController pid =  new PIDController(0.5, 0, 0.9);;
  private final double setPoint;
  private final ArmFeedforward armFeedforward = new ArmFeedforward(0.3, 0, 0.7);
  private final ArmSubsystem armSubsystem;
  /** Creates a new SetArmtoPoint. */
  public SetArmtoPoint(ArmSubsystem armSubsystem, double setPoint) {
    this.armSubsystem = armSubsystem;
    this.setPoint = setPoint;    
    //Proportional, responds to error that produces an output proportional to error's magnitude
    //Integral:Addresses past errors, accumulates them
    //Derivative: Predicts future errors
    //closed loop- feedback, open loop, no feedback
    //feedforward, reduces error
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast();
    armSubsystem.setPower(0);
    pid.setTolerance(5,10);
    pid.setSetpoint(setPoint);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      double position = armSubsystem.getPosition();
      double output = armFeedforward.calculate(position, setpoint) + pid.calculate(position);
      armSubsystem.runMotor(output);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    return armSubsystem.atSetPoint();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
