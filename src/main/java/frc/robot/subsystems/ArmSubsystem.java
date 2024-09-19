package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.smartdashboard.SmartDashboard;

//
public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final TalonFX armMotor;
  public ArmSubsystem() {
    this.armMotor = new TalonFX(Constants.ShooterConstants.topShooterID, Constants.RobotConstants.kCanbus);
      }

  public void coast(){
    armMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake(){
    armMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public setPower(double power){
    armMotor.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("ARM MOTOR VOLTAGE", armMotor.getMotorVoltage().getValue());
  }
}
