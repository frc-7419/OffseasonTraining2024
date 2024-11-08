package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.CANBus;
import frc.robot.Constants;

public class DriveBaseSubsystem extends SubsystemBase {
    private final TalonFX leftLeaderMotor;
    private final TalonFX leftFollowerMotor;
    private final TalonFX rightLeaderMotor;
    private final TalonFX rightFollowerMotor;

    public DriveBaseSubsystem() {
        leftLeaderMotor = new TalonFX(Constants.CANIds.leftFalcon1);
        leftFollowerMotor = new TalonFX(Constants.CANIds.leftFalcon2);
        rightLeaderMotor = new TalonFX(Constants.CANIds.rightFalcon1);
        rightFollowerMotor = new TalonFX(Constants.CANIds.rightFalcon2);

        // Set inversion for leaders and followers
        leftLeaderMotor.setInverted(true);
        leftFollowerMotor.setInverted(true); // Set followers to the same inversion

        rightLeaderMotor.setInverted(false); // Assuming the right side is not inverted
        rightFollowerMotor.setInverted(false); // Set followers to the same inversion

        // Make followers follow the leaders
        leftFollowerMotor.follow(leftLeaderMotor);
        rightFollowerMotor.follow(rightLeaderMotor);
    }

    public void setPower(double leftPower, double rightPower) {
        leftLeaderMotor.set(ControlMode.PercentOutput, leftPower);
        rightLeaderMotor.set(ControlMode.PercentOutput, rightPower);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Left Leader Power", leftLeaderMotor.getMotorOutputPercent());
        SmartDashboard.putNumber("Right Leader Power", rightLeaderMotor.getMotorOutputPercent());
        // You do not output the power of the following motors because it is the same.
        SmartDashboard.putNumber("Left Leader Temp", leftLeaderMotor.getTemperature());
        SmartDashboard.putNumber("Right Leader Temp", rightLeaderMotor.getTemperature());
        SmartDashboard.putNumber("Left Follower Temp", leftFollowerMotor.getTemperature());
        SmartDashboard.putNumber("Right Follower Temp", rightFollowerMotor.getTemperature());
    }
}
