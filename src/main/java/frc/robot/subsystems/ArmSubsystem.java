// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
    private final TalonFX armMotor;
    // private final ArmSubsystem wristMotor;
    private final XboxController xBoxController;
  /** Creates a new ExampleSubsystem. */
  public ArmSubsystem() {
    this.xBoxController = new XboxController(0);
    this.armMotor = new TalonFX(0);
    
  }
    public void coast(){
        armMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake(){
        armMotor.setNeutralMode(NeutralModeValue.Brake);
    }
    
    public void runMotor(double power){
        armMotor.set(xBoxController.getLeftY());
        //armMotor.set(power)
    }
    public double getPosition(){
        return armMotor.getPosition().getValue();
        
        //position of actual motor
    }
    

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Arm motor",armMotor.getMotorVoltage().getValue());
    //SmartDashboard
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


}
