package frc.robot.AssessmentZero;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.wpilibj2.smartDashboard;
// import edu.wpi.wpilibj2.NeutralModeValue;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterMotorSubsystem extends SubsystemBase{
    private final TalonFX bottomShooterMotor;
    private final TalonFX topShooterMotor;
    private final TalonFX armMotor;

    public ShooterMotorSubsystem(){
      bottomShooterMotor = new TalonFX(0);
      topShooterMotor = new TalonFX(1);
      armMotor = new TalonFX(2);
    }

  public void coast(){
    topShooterMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomShooterMotor.setNeutralMode(NeutralModeValue.Coast);
    armMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  
 public void brake(){
    topShooterMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomShooterMotor.setNeutralMode(NeutralModeValue.Brake);
    armMotor.setNeutralMode(NeutralModeValue.Brake);

 } 

 public void runShooterMotor(double power){
    topShooterMotor.set(power);
    bottomShooterMotor.set(power);
 }
 public void runArmMotor(double power){
      armMotor.set(power);
 }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("topShooterMotor Angle",topShooterMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("bottomShooterMotor Angle",bottomShooterMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("armMotor Voltage",armMotor.getMotorVoltage().getValue());
    // This method will be called once per scheduler run
  }
}

