package frc.robot.Subsystems;

import java.nio.file.attribute.FileOwnerAttributeView;

import com.ctre.phoenix6.signals.NeutralModeValue;

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
    armMotor.setNeutralMode(NeutralModeValue.Coast);
  }

public void brake(){
    armMotor.setNeutralMode(NeutralModeValue.Brake);
  }   

@Override
  public void periodic() {
    SmartDashboard.putNumber("arm motor voltage", armMotor.getMotorVoltage().getValue());
  }

}