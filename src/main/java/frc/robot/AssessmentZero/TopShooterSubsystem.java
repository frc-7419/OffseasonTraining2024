package frc.robot.subsystems;
import com.ctre.hardware.phoenix6.TalonFX;
import com.ctre.signlas.phoenix6.TalonFX;
import edu.wpi.wpilibj2.smartDashboard;
import edu.wpi.wpilibj2.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TopShooterSubsystem extends SubsystemBase {
    private final topShooterMotor = TalonFX(2);
  /** Creates a new ExampleSubsystem. */
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
