package frc.robot.subsystems;
import com.ctre.hardware.phoenix6.TalonFX;
import com.ctre.signlas.phoenix6.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.wpilibj2.smartDashboard;
import edu.wpi.wpilibj2.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BottomShooterSubsystem extends SubsystemBase {
    private final bottomShooterMotor = TalonFX(0);
  /** Creates a new ExampleSubsystem. */
  public TopShooterSubsystem() {
    
  }
  public void coast(){
    topShooterMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  
 public void brake(){
    topShooterMotor.setNeutralMode(NeutralModeValue.Brake);

 } 

 public void runBottomMotor(double power){
    topShooterMotor.set(power);

 }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Arm motor Angle",shooterAngleMotor.getMotorVoltage().getValue());
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
