package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;
/*Note the integer axis is used to control loader speed 
    by getting input from specified axis
*/
public class IntakeCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;
    private final Joystick joystick;
    private final int axis;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, Joystick joystick, int axis) {
        this.intakeSubsystem = intakeSubsystem;
        this.joystick = joystick;
        this.axis = axis;
        addRequirements(intakeSubsystem);
    }
    public void initialize() {
        intakeSubsystem.coast();
    }
    @Override
    public void execute() {
        double speed = joystick.getRawAxis(axis);  
        intakeSubsystem.setIntakeSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stopIntake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    
}
