package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LoaderSubsystem;
import edu.wpi.first.wpilibj.Joystick;
/*Note the integer axis is used to control loader speed 
    by getting input from specified axis
*/
public class LoaderCommand extends CommandBase {
    private final LoaderSubsystem loaderSubsystem;
    private final Joystick joystick;
    private final int axis;

    public LoaderCommand(LoaderSubsystem loaderSubsystem, Joystick joystick, int axis) {
        this.loaderSubsystem = loaderSubsystem;
        this.joystick = joystick;
        this.axis = axis;
        addRequirements(loaderSubsystem);
    }
    public void initialize() {
        loaderSubsystem.coast();
    }
    @Override
    public void execute() {
        double speed = joystick.getRawAxis(axis); 
        loaderSubsystem.setLoaderSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        loaderSubsystem.stopIntake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
