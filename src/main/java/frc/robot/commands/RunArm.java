
package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class RunArm extends Command{
  private final ArmSubsystem armSubsystem;
  private final double power;
  /** Creates a new RunArm. */
  public RunArm(ArmSubsystem armSubsystem, double power) {
    this.armSubsystem = armSubsystem;
    this.power = power;
  }

  // Called when the command is initially scheduled.
  public void initialize() {
    armSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
    armSubsystem.runMotor(power);
  }

  // Called once the command ends or is interrupted.
  public void end(boolean interrupted) {
    armSubsystem.brake();
  }

  // Returns true when the command should end.
  public boolean isFinished() {
    return false;
  }
}