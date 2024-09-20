package frc.robot.subsystems;
import com.ctre.hardware.phoenix6.TalonFX;
import com.ctre.signlas.phoenix6.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.wpilibj2.smartDashboard;
import edu.wpi.wpilibj2.NeutralModeValue;
public class ShooterAngleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final shooterAngleMotor = TalonFX(1);
  public ShooterAngleSubsystem() {
    this.shooterAngleMotor = ShooterAngleSubsystem shooterAngleMotor;
    
    public void coast(){
      shooterAngleMotor.setNeutralMode(NeutralModeValue.Coast);
    }
    
   public void brake(){
      shooterAngleMotor.setNeutralMode(NeutralModeValue.Brake);

   } 

   public void runShooterMotor(double power){
    shooterAngleMotor.set(power);

   }
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
