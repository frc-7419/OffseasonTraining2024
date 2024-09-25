package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PidController;

public class SetArmToPoint extends CommandBase {
    private final ArmSubsystem armSubsystem;
    private double setpoint;
    private final PIDController pidController = new PidController(1.0,0.0,0.1);
    private final ArmFeedforward feedforward = new ArmFeedforward(0.0,1.0,0.5,0.1);


  public SetArmToPoint (ArmSubsystem armSubsystem, double setpoint) {
    this.armSubsystem = armSubsystem;
    this.setPoint = setPoint;    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast():
    armSubsystem.setPower(0);
    pidController.setTolerance(5,10);
    pidController.setSetpoint(setPoint);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double currentPosiiton = armSubsystem.getPosition();
    double ff = armFeedforward.calculate(currentPosition,setPoint); //feedforward, ask lead`
    double pidValue = pidController.calculate(currentPosition);
    armSubsystem.setPower(pidValue+ff);
    //pid value+ feedForward
    
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
    return pidController.atSetPoint();
    //at the desired point
  }
}
