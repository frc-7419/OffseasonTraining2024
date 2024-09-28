package frc.robot.commands;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.ArmSubsystem;

public class SetArmSetpoint extends Command {
    private ArmSubsystem arm;
    private double setPoint;
    private final ProfiledPIDController pidController = new ProfiledPIDController(1.0, 0.0, 0.1, null);
    private final ArmFeedforward feedForward = new ArmFeedforward(0.0, 1.0, 0.5, 0.1);

    public SetArmSetpoint(ArmSubsystem Arm, double setPoint) {
        this.arm = Arm;
        this.setPoint = setPoint;
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        arm.coast();
        arm.runMotor(0);
        pidController.setGoal(setPoint);
        pidController.setTolerance(ShooterConstants.SetpointThreshold);
    }

    @Override
    public void execute() {
        double position = arm.getPosition();
        double ff = feedForward.calculate(position, setPoint);
        double pid = pidController.calculate(position);
        arm.runMotor(ff+pid);
    }

    @Override
    public void end(boolean interrupted) {
        arm.runMotor(0);
        arm.brake();
    }

    @Override
    public boolean isFinished() {
        return shooterWristPIDController.atgoal();
    }
}