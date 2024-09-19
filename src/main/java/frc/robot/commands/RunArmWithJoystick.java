package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ArmSubsystem;

public class RunArmWithJoystick extends Command {
  private final ArmSubsystem armSubsystem;
  private final CommandXboxController joystick;

//i
  public RunArmWithJoystick(ArmSubsystem armSubsystem, CommandXboxController joystick) {
    this.armSubsystem = armSubsystem;
    this.joystick = joystick;
    addRequirements(armSubsystem);
  }

  @Override
  public void initialize() {
    armSubsystem.coast();
  }

  @Override
  public void execute() {
    armSubsystem.runMotor(joystick.getLeftY());
  }

  @Override
  public void end(boolean interrupted) {
    armSubsystem.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}