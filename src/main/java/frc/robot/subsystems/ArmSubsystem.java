package frc.robot.Subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

private final TalonFX armMotor;
    public ArmSubsystem() {
      this.armMotor = new TalonFX(0);
     
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
    /*public float lerp(float a, float b, float f) 
  {
      return (a * (1 - f)) + (b * f);
  }*/
    public double getPosition(){
      return armMotor.getPosition().getValueAsDouble();
    }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("arm motor voltage", armMotor.getMotorVoltage().getValue());
  }
}