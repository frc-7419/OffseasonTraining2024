package frc.robot.subsystems;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class ArmPID extends Command {
    private shooterWrist shooterWrist;
    private double setpoint;
    private final PIDController pidController  = new PIDController(1.0, 0.0, 0.1);
    private final ArmFeedforward feedForward  = new ArmFeedforward(0.0, 1.0, 0.5, 0.1);
    
    public setArmSetpoint(ShooterWrist shooterWrist, double setpoint) {
        this.shooterWrist = shooterWrist;
        this.setpoint = setpoint;
        addRequirements(shooterWrist);
    }
    @Override
    public void initialize() {
        shooterWrist.coast();
        shooterWrist.setPower(0);
        pidController.setGoal(setpoint);
        pidController.setTolerance(ShooterConstants, SetpointThreshold);
    }
    @Override
    public void execute() {
        double position = shooterWrist.getPosition();
        double ff = feedForward.calculate(position, setpoint);
        double pid = pidController.calculate(position);
        shooterWrist.setPower(ff+pid);
    }
    @Override
    public void end(boolean interrupted) {
        shooterWrist.setPower();
        shooterWrist.brake();
    }
    @Override
    public boolean isFinished() {
        return shooterWristPIDController.atGoal()
    }
}
