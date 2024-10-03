package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class GyroCommand extends Command {
    private final ArmSubsystem arm;
    private final GyroSubsystem gyro;

    public GyroCommand(ArmSubsystem arm, GyroSubsystem gyro) {
        this.arm = arm;
        this.gyro = gyro;
        addRequirements(arm);
        addRequirements(gyro);
    }

    @Override
    public void execute() {
        // A higher pitch means the robot is moving up, so the arm should move up to maintain its position relative to the robot.
        if (gyro.getGyroPitch() > 90) {
            arm.runMotor(0.5);
            arm.brake();
        }
    }

    @Override  
    public boolean isFinished() {
        return false;
    }
}