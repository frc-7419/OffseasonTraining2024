package frc.robot.subsystems;
import com.ctre.hardware.phoenix6.TalonFX;
import com.ctre.signals.phoenix6.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class DriveBaseSubsystem extends SubsystemBase {
    //arcade drive involves joytick, one side for turning left and right, and other for front and back
    //sets up all the motors
    private final TalonFX rightFrontMotor; 
    private final TalonFX rightBackMotor;
    private final TalonFX leftFrontMotor;
    private final TalonFX leftBackMotor;
    private final Joystick joystick = new Joystick(0);
    

    public DriveBaseSubsystem(){
        this.rightFrontMotor = new TalonFX(0);
        this.rightBackMotor = new TalonFX(1);
        this.leftFrontMotor = new TalonFX(2);
        this.leftBackMotor = new TalonFX(3);
        //combines front and back motors 
        this.joystick = joystick;
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
      rightFrontMotor.setPower(rightPower);
      rightBackMotor.setPower(rightPower);
      leftFrontMotor.setPower(leftPower);
      leftBackMotor.setPower(leftPower);
      //this is a test
    }
            
  }
  @Override
  public void periodic() {
    rightFrontMotor.set("Front right motor",rightFrontMotor.getMotorVoltage().getValue());
    rightBackMotor.set("Back right motor",rightBackMotor.getMotorVoltage().getValue());
    leftFrontMotor.set("Front left motor",leftFrontMotor.getMotorVoltage().getValue());
    leftBackMotor.set("Back left motor",leftBackMotor.getMotorVoltage().getValue());
    //SmartDashboard
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }



