package frc.robot.assessmentZero;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class Joystick extends Command {
    private final IntakeSubsystem intakeSubsystem;
    private final ShooterSubsystem shooterSubsystem;
    private final XboxController controller;

    public IntakeWithJoystickCommand(IntakeSubsystem intakeSubsystem, XboxController controller) {
        this.intakeSubsystem = intakeSubsystem;
        this.controller = controller;
        addRequirements(intakeSubsystem);
    }

    public ShootWithJoystickCommand(ShooterSubsystem shooterSubsystem, XboxController controller) {
        this.shooterSubsystem = intakeSubsystem;
        this.controller = controller;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {
        intakeSubsystem.coast();
        shooterSubsystem.coast();
    }

    @Override
    public void execute() {
        double intakeSpeed = controller.getLeftY();
        double shooterSpeed = controller.getRightY();
        intakeSubsystem.setSpeed(intakeSpeed);
        shooterSubsystem.setSpeed(shooterSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.setSpeed(0);
        shooterSubsystem.setSpeed(0);
        intakeSubsystem.brake();
        shooterSubsystem.brake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
