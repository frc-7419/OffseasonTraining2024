package frc.robot.AssessmentZero;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.AssessmentZero.ShooterMotorSubsystem;

public class AdjustAngleShooter extends CommandBase{
  private final ShooterMotorSubsystem bottomShooterMotor;
  private final ShooterMotorSubsystem topShooterMotor;
  
  private final XboxController joystick;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AdjustAngleShooter(ShooterMotorSubsystem topShooterMotor,ShooterMotorSubsystem bottomShooterMotor) {
    this.joystick = new XboxController(0);
    this.bottomShooterMotor = bottomShooterMotor;
    this.topShooterMotor = topShooterMotor;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    bottomShooterMotor.coast();
    topShooterMotor.coast();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    topShooterMotor.runTopMotor(joystick.getLeftY());
    bottomShooterMotor.runBottomMotor(joystick.getLeftY());

  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    bottomShooterMotor.brake();
    topShooterMotor.brake();
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
