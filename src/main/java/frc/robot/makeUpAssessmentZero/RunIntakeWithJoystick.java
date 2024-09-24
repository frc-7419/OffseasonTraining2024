package frc.robot.makeUpAssessmentZero;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.makeUpAssessmentZero.IntakeSubsystem;
import frc.robot.makeUpAssessmentZero.LoaderSubsystem;

public class RunIntakeWithJoystick extends Command{

    private final IntakeSubsystem intake;
    private final LoaderSubsystem loader;
    private final CommandXboxController joystick;
    
    public RunIntakeWithJoystick(IntakeSubsystem intakeSubsystem, LoaderSubsystem loaderSubsystem, CommandXboxController joystick) {
        this.intake = intakeSubsystem;
        this.loader = loaderSubsystem;
        this.joystick = joystick;
        addRequirements(intake, loader);
    }

    @Override
    public void initialize() {
        intake.coastIntakeMotors();
        loader.coastLoaderMotors();
    }

    @Override
    public void execute() {
        intake.runIntakeMotors(joystick.getLeftY());
        loader.runLoaderMotors(joystick.getRightY());

        if (joystick.leftBumper().getAsBoolean()) {
            // Any code here will run when the button (left bumper) is pressed
        }
    }

    @Override
    public void end(boolean interrupted) {
        intake.brakeIntakeMotors();
        loader.brakeLoaderMotors();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}