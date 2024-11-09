package frc.robot;
/* 
Imports necessary packages to run FRC commands
*/
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.RunArmWithJoystick;
import frc.robot.commands.SwerveDriveCommand;
import frc.robot.commands.TwoNoteAuton;
import frc.robot.subsystems.ArmSubsystem;

//Loader & Intake Subsystems
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LoaderSubsystem;
import frc.robot.subsystems.SwerveDriveSubsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.LoaderCommand;
import frc.robot.commands.IntakeCommand;



// Creating an instance of the different members. 
public class RobotContainer {
  private final CommandXboxController driveJoystick = new CommandXboxController(Constants.Operator.kdriveControllerPort);
  private final ArmSubsystem arm = new ArmSubsystem();
  private final RunArmWithJoystick runArmWithJoystick = new RunArmWithJoystick(arm, driveJoystick);
  private final Command runArmJoystick = new RunCommand(()->arm.runMotor(driveJoystick.getLeftY()), arm);
  //Loader and Intake Subsystems
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final LoaderSubsystem loaderSubsystem = new LoaderSubsystem();
  
  //Alternative
  private final IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem, driveJoystick);
  private final LoaderCommand loaderCommand = new LoaderCommand(loaderSubsystem, driveJoystick);

  private final SwerveDriveSubsystem swerveDriveSubsystem = new SwerveDriveSubsystem();
  private final XboxController controller = new XboxController(0); // Controller ID
  private final CommandBase swerveDriveCommand = new SwerveDriveCommand(swerveDriveSubsystem, controller);


public RobotContainer() {
    configureBindings();
    configureButtonBindings();
    swerveDriveSubsystem.setDefaultCommand(swerveDriveCommand);
  }

//I was not sure how to do this, so I just used online resources + WPILIB Docs

 private void configureButtonBindings() {
        // Button A to control intake with joystick axis 1
        private final JoystickButton intakebutton= new JoystickButton(joystick, 1).whileHeld(new IntakeCommand(intakeSubsystem, joystick, 1));  // Controls intake via axis 1

        // Button B controlls the laoder with joystick axis 2
        private final JoystickButton loaderbutton = new JoystickButton(joystick, 2).whileHeld(new LoaderCommand(loaderSubsystem, joystick, 2));  // Control loader via axis 2
    }

  

  public void initialize() {
      CommandScheduler.getInstance().schedule(swerveDriveCommand);
  }
  private void configureBindings() {
    driveJoystick.rightBumper().getAsBoolean();
  }
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
    // could also return null
  }
  public void setDefaultCommands() {
    arm.setDefaultCommand(runArmWithJoystick);
    intake.setDefaultCommand(intakebutton);
    loader.setDefaultCommand(loaderloaderbutton)

    //Alternative
    intake.setDefaultCommand(intakeCommand)
    loader.setDefaultCommand(loaderCommand)
  }
  public Command getAutonomousCommand() {
        // Return the two-note autonomous command
        return new TwoNoteAuton(swerveDriveSubsystem);
    }
  public void robotPeriodic() {
        CommandScheduler.getInstance().run();
  }
}