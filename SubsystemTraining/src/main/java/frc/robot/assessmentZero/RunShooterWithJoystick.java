package frc.robot.assessmentZero;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RunShooterWithJoystick extends Command {
    private ShooterSubsystem shooterSubsystem;
    private CommandXboxController joystick;

    public RunShooterWithJoystick(ShooterSubsystem shooterSubsystem, CommandXboxController joystick) {
        shooterSubsystem = new ShooterSubsystem();
        joystick = new CommandXboxController(0);
        addRequirements(shooterSubsystem);
    }

    public void initialize() {
        shooterSubsystem.coast();
    }

    public void execute() {
        shooterSubsystem.setFlywheelSpeed(joystick.getRightY());
        shooterSubsystem.adjustAngle(10);        
    }
    
    public void shootNote() {
        shooterSubsystem.shootNote(true, 1);
    }

    public void adjustAngle() {
        shooterSubsystem.adjustAngle(10);        
    }

    public void end() {
        shooterSubsystem.brake();
    }
}
