package frc.robot;
/* 
Imports necessary packages to run FRC commands
*/
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.RunArmWithJoystick;
import frc.robot.subsystems.ArmSubsystem;

// Creating an instance of the different members. 
public class RobotContainer {
  private final CommandXboxController driveJoystick = new CommandXboxController(Constants.Operator.kdriveControllerPort);
  private final ArmSubsystem arm = new ArmSubsystem();
  private final RunArmWithJoystick runArmWithJoystick = new RunArmWithJoystick(arm, driveJoystick);
  private final Command runArmJoystick = new RunCommand(()->arm.runMotor(driveJoystick.getLeftY()), arm);


  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}
  private void configureBindings() {
    driveJoystick.rightBumper().getAsBoolean();
  }
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
  public void setDefaultCommands() {
    arm.setDefaultCommand(runArmWithJoystick);
  }
}