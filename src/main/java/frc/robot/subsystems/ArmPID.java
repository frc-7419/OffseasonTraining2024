package frc.robot.subsystems;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;

public class ArmPID<armSubsystem> extends Command {
    private ArmSubsystem armSubsystem; // declare arm from ArmSubsystem
    private double setpoint; // declare joystick
    private final PIDController pidController  = new PIDController(1.0, 0.0, 0.1);
    private final ArmFeedforward feedForward  = new ArmFeedforward(0.0, 1.0, 0.5, 0.1);

    public void ArrmPID(ArmSubsystem armSubsystem, double setpoint) {
        this.armSubsystem = armSubsystem;
        this.setpoint = setpoint;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        armSubsystem.coast();
        armSubsystem.setVoltage(0);
        pidController.setSetpoint(setpoint);
        pidController.setTolerance(10);
    }

    @Override
    public void execute() {
        double position = armSubsystem.getPosition(); // fix
        double ff = feedForward.calculate(position, setpoint);
        double pid = pidController.calculate(position);
        armSubsystem.setVoltage(ff+pid);
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.setVoltage(0);
        armSubsystem.brake();
    }

    @Override
    public boolean isFinished() {
        return pidController.atSetpoint();
    }
}

