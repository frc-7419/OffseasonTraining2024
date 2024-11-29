package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class DriveBaseSubsystem extends SubsystemBase {
    //arcade drive involves joytick, one side for turning left and right, and other for front and back
    //sets up all the motors
    private final TalonFX rightFrontMotor; 
    private final TalonFX rightBackMotor;
    private final TalonFX leftFrontMotor;
    private final TalonFX leftBackMotor;
    private final Joystick joystick;
    

    public DriveBaseSubsystem(){
        this.rightFrontMotor = new TalonFX(0);
        this.rightBackMotor = new TalonFX(1);
        this.leftFrontMotor = new TalonFX(2);
        this.leftBackMotor = new TalonFX(3);
        this.joystick = new Joystick(0);
        //combines front and back motors 
        // this.joystick = joystick;
    }
        public void coast(){
        rightFrontMotor.setNeutralMode(NeutralModeValue.Coast);
        rightBackMotor.setNeutralMode(NeutralModeValue.Coast);
        leftFrontMotor.setNeutralMode(NeutralModeValue.Coast);
        leftBackMotor.setNeutralMode(NeutralModeValue.Coast);
    }


    public void brake(){
        rightFrontMotor.setNeutralMode(NeutralModeValue.Brake);
        rightBackMotor.setNeutralMode(NeutralModeValue.Brake);
        leftFrontMotor.setNeutralMode(NeutralModeValue.Brake);
        leftBackMotor.setNeutralMode(NeutralModeValue.Brake);
    }
    
    public void runMotor(double leftPower, double rightPower){
      rightFrontMotor.set(rightPower);
      rightBackMotor.set(rightPower);
      leftFrontMotor.set(leftPower);
      leftBackMotor.set(leftPower);

    }
            
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Front right motor",rightFrontMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Back right motor",rightBackMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Front left motor",leftFrontMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Back left motor",leftBackMotor.getMotorVoltage().getValue());
    //SmartDashboard
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}



