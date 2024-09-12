package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsytem extends SubsystemBase {

private final TalonFX armMotor;

public ArmSubsytem() {
    this.armMotor = new TalonFX(0);
  }

public void setPower(double power){
    armMotor.setPower(power);
  }

public void coast() {
    armMotor.setNeutralMode(NeutralModeValue.coast);
  }

public void brake(){
    armMotor.setNeutralMode(NeutralModeValue.brake);
  }   

@Override
  public void periodic() {
    SmartDashboard.putNumber("arm motor voltage", armMotor.getMotorVoltage().getValue());
  }

}