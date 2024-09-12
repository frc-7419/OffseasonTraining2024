package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

  private final TalonFX armMotor;
  public ArmSubsystem() {
    this.armMotor = new TalonFX(Constants.ShooterConstants.topShooterID, Constants.RobotConstants.kCanbus);
    armMotor.setInverted(true);
    }
    public void coast(){
        armMotor.setNeutralMode(NeutralModeValue.Coast);
    }
    public void brake(){
      armMotor.setNeutralMode(NeutralModeValue.Brake);
    }
    public void setPower(double power){
      armMotor.set(power);
    }

    @Override
    public void periodic() {
    }
}