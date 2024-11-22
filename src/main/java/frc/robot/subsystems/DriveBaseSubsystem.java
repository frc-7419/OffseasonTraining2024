package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class DriveBaseSubsystem {
    private final CANSparkMax leftLeader;
    private final CANSparkMax leftFollower;
    private final CANSparkMax rightLeader;
    private final CANSparkMax rightFollower;

    public DriveBaseSubsystem () {
        this.leftLeader = new CANSparkMax(1, MotorType.kBrushless);
        this.leftFollower = new CANSparkMax(2, MotorType.kBrushless);
        this.rightLeader = new CANSparkMax(3, MotorType.kBrushless);
        this.rightFollower = new CANSparkMax(4, MotorType.kBrushless);
    }

    public void invertMotors() {
        // leftLeader.setInverted(true);
        // leftFollower.setInverted(false);
        // rightLeader.setInverted(true);
        // rightFollower.setInverted(false);
      }

}
