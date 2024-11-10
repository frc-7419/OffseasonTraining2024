package frc.robot.AssessmentZero;
import frc.robot.AssessmentZero.ShooterMotorSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class ShootProjectile extends Command {
    private final XboxController xboxController;
    private final ShooterMotorSubsystem shooterMotorSubsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShootProjectile(ShooterMotorSubsystem shooterMotorSubsystem) {
    this.shooterMotorSubsystem = shooterMotorSubsystem;
    this.xboxController = xboxController;
  }


  public void initialize() {
    shooterMotorSubsystem.coast();

  }
  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
    shooterMotorSubsystem.runShooterMotor(xboxController.getLeftY());
    shooterMotorSubsystem.runArmMotor(xboxController.getLeftX());
  }
  // Called once the command ends or is interrupted.
  public void end(boolean interrupted) {
    shooterMotorSubsystem.brake();
  }

  // Returns true when the command should end.
  public boolean isFinished() {
    return false;
  }
}
