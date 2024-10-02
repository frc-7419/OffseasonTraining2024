package frc.robot.commands;

import frc.robot.Subsystems.AcceleroemeterSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MeasureAcceleration extends CommandBase {
  private final AccelerometerSubsystem accelerometerSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MeasureAcceleration(AccelerometerSubsystem accelerometerSubsystem) {
    this.accelerometerSubsystem = accelerometerSubsystem;
    
    addRequirements(acceleometerSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {


    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    acclerometerSubsystem.periodic();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
