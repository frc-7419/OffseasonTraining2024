package frc.robot.commands;
import edu.wpi.first.wpilibj2.button.CommandXboxController.xboxcontroller;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShootProjectile extends CommandBase {
    private final TopShooterSubsystem topShooterMotor;
    private final BottomShooterSubsystem bottomShooterMotor;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShootProjectile(TopShooterSubsystem topShooterMotor,BottomShooterSubsystem bottomShooterMotor) {
    this.ShooterAngleSubsystem = shooterAngleMotor;
    this.joystick = joystick;
    addRequirements(shooterAngleMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    topShooterMotor.coast();
    bottomShooterMotor.coast();

  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterAngleMotor.runShooterMotor(joystick.getLeftY());
    topShooterMotor.runShooterMotor(rawButtomPressed());
    bottomShooterMotor.runShooterMotor(rawButtomPressed());
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    topShooterMotor.brake();
    bottomShooterMotor.brake();
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    }

