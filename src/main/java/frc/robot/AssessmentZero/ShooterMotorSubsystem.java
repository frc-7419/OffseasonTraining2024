package frc.robot.AssessmentZero;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class ShooterMotorSubsystem extends SubsystemBase {
    private final TalonFX bottomShooterMotor;
    private final TalonFX topShooterMotor;

  /** Creates a new ExampleSubsystem. */
  public ShooterMotorSubsystem() {
    this.bottomShooterMotor = new TalonFX(0);
    this.topShooterMotor = new TalonFX(1);
    
  }
  public void coast(){
    topShooterMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomShooterMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  
 public void brake(){
    topShooterMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomShooterMotor.setNeutralMode(NeutralModeValue.Brake);

 } 

 public void runBottomMotor(double power){
    bottomShooterMotor.set(power);

 }
  public void runTopMotor(double power){
    topShooterMotor.set(power);

 }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Arm motor Angle",topShooterMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Arm motor Angle",bottomShooterMotor.getMotorVoltage().getValue());
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
