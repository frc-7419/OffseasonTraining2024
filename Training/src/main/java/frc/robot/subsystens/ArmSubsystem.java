package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

  private final TalonFX armMotor;
  public ArmSubsystem() {
    this.armMotor = new TalonFX(Constants.ShooterConstants.topShooterID, Constants.RobotConstants.kCanbus);
    armMotor.setInverted(true);
    }

    public void coast(){
        armMotor.setNeutralMode(NeutralModeValue.coast);
    }
      public void brake(){
        armMotor.setNeutralMode(NeutralModeValue.brake);
      }
      public setPower(power){
        armMotor.set(power);
      }

  @Override
  public void periodic() {

  }
}