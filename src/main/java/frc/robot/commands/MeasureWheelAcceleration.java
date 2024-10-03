package frc.robot.commands;

import frc.robot.subsystems.AccelerometerSubsystem;
import frc.robot.subsystems.WheelSubsystem;
// import edu.wpi.first.wpilibj2.command.CommandBase;

public class MeasureWheelAcceleration extends CommandBase {
  private final AccelerometerSubsystem accelerometerSubsystem;
  private final WheelSubsystem wheelMotor;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MeasureWheelAcceleration(AccelerometerSubsystem accelerometerSubsystem) {
    this.accelerometerSubsystem = accelerometerSubsystem;
    this.wheelMotor = wheelMotor;
    addRequirements(accelerometerSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //set motor to neutral
    wheelMotor.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //get velocity and run the motor
    wheelMotor.runMotor(0.5);
    wheelMotor.getMotorVelocity();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //stop the motor
    wheelMotor.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
