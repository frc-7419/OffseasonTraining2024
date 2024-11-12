package frc.robot.Commands;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.ArmSubsystem;
import frc.robot.Subsystems.ExampleSubsystem;

public class PIDCommand extends Command {   
    private final ArmSubsystem armSubsystem;
    private final double setpoint;
    private final PIDController pidController = new PIDController(0.9, 0.1, 0.9);
    private final ArmFeedforward armFeedforward = new ArmFeedforward(0.9, 0.1, 0.9);

    public void ArmtoSetPoint(ArmSubsystem armSubsystem, double setpoint) {
        this.armSubsystem = armSubsystem;
        this.setpoint = setpoint;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        armSubsystem.coast();
        armSubsystem.runMotor(0);
        pidController.setSetpoint(setpoint);
        pidController.setTolerance(1.0);
    }

    @Override
    public void execute() {
        double position = armSubsystem.getPosition();
        double output = armFeedforward.calculate(position, setpoint) + pidController.calculate(position);
        armSubsystem.runMotor(output);
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.runMotor(0);
        armSubsystem.brake();
    }

    @Override
    public boolean isFinished() {
        return pidController.atSetpoint();
    }
}