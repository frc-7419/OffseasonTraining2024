package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ArmSubsystem;

public class RunArmWithJoystick extends Command {
  private final ArmSubsystem armsubsystem;
  private final CommandXboxController joystick;

//i
  public RunArmWithJoystick(ArmSubsystem armsubsystem, CommandXboxController joystick) {
    this.armsubsystem = armsubsystem;
    this.joystick = joystick;
    addRequirements(armsubsystem);
  }

  @Override
  public void initialize() {
    armsubsystem.coast();
  }

  @Override
  public void execute() {
    armsubsystem.runMotor(joystick.getLeftY());
  }

  @Override
  public void end(boolean interrupted) {
    armsubsystem.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}