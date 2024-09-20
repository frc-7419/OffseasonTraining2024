package frc.robot.commands;
import edu.wpi.first.wpilibj2.button.CommandXboxController.xboxcontroller;
import edu,wpi.first.wpilibj2.CommandXboxController.joystick;
import frc.robot.subsystems.ShooterAngleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AdjustAngleShooter extends CommandBase {
  private final ShooterAngleSubsystem shooterAngleMotor;
  private final joystick = CommandXboxController joystick;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AdjustAngleShooter(ShooterAngleSubsystem shooterAngleMotor) {
    this.ShooterAngleSubsystem = shooterAngleMotor;
    this.joystick = joystick;
    addRequirements(shooterAngleMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterAngleMotor.coast();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterAngleMotor.runShooterMotor(joystick.getLeftY());
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterAngleMotor.brake();
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
