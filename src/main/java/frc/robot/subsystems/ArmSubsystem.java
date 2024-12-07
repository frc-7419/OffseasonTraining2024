// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
    private final TalonFX armMotor;
    // private final ArmSubsystem wristMotor;
    private final XboxController xBoxController;
  /** Creates a new ExampleSubsystem. */
  public ArmSubsystem() {
    this.armMotor = new TalonFX(0);
    this.xBoxController = xBoxController;
  }
    public void coast(){
        armMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake(){
        armMotor.setNeutralMode(NeutralModeValue.Brake);
    }
    
    public void runMotor(double power){
        armMotor.set(xBoxController.getLeftY());
        
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
}




// package frc.robot.subsystems;
// import com.ctre.phoenix6.hardware.TalonFX;
// import com.ctre.phoenix6.signals.NeutralModeValue;
// import edu.wpi.first.wpilij.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// public class ArmSubsystem{
//     private final ArmSubsystem armMotor;
//     private final ArmSubsystem armMotor1;
//     private final ArmSubsystem armMotor2;
//     private final ArmSubsystem Xboxcontroller;
//     public ArmSubsystem(){
//         this.armMotor = new TalonFX(0);
//         this.armMotor1 = new TalonFX(1);
//         this.armMotor2 = new TalonFX(2);
//         this.Xboxcontroller = new Xboxcontroller;
//     }
//     public void RunMotor(double power){
//         armMotor.setPower(Xboxcontroller.LeftY());
//         armMotor1.setPower(Xboxcontroller.rawButtomPressed());

//     }
//     public void coast(){
//         armMotor.setNeutralMode(NeutralModeValue.Coast);
        

//     }
//     public void brake(){
//         armMotor1.setNeutralMode(NeutralModeValue.Brake);
//     }

//     public void periodic(){
//         smartDashboard.putNumber("ArmMotorvalue",SmartDashboard.getMotorVoltage().getNumber);
//     }

// }
 
// package frc.robot.subsystems;
// import com.ctre.phoenix6.hardware.TalonFX;
// import com.ctre.phoenix6.sigals.NeutralModeValue;
// import edu.wpi.first.wpilij.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// //review top import

// public class ArmSubsystem{
//   private final TalonFX armMotor;

//   public ArmSubsystem(){
//     this.armMotor = new TalonFX(0);
//   }

//   public void runMotor(double power){
//     armMotor.setPower(power);
//   }

//   public void coast(){
//     armMotor.setNeutralMode(NeutralModeValue.Coast);
//     //NeutralModeValue, not setNeutralMode

//   }

//   public void brake(){
//     armMotor.setNeutralMode(NeutralModeValue.Brake);
//   }

//   @Override
//   public void periordic(){
//     SmartDashboard.getNumber("Arm Motor Voltage",armMotor.getMotorVoltage().getValue());
//     //putNumber


//   }



// }





















// package frc.robot.subsystems;
// import com.ctre.phoenix6.hardware.TalonFX;
// import com.ctre.phoenix6.signals.NeutralModeValue;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class ArmSubsystem extends SubsystemBase {

// private final TalonFX armMotor;
//     public ArmSubsystem() {
//       this.armMotor = new TalonFX(0);
//     }

//     public void coast(){
//         armMotor.setNeutralMode(NeutralModeValue.Coast);
//     }
//     public void brake(){
//         armMotor.setNeutralMode(NeutralModeValue.Brake);
//       }
//     public void setPower(double power){
//         armMotor.set(power);
//     }

//   @Override
//   public void periodic() {
//     SmartDashboard.putNumber("ArmMotorVoltage",armMotor.getMotorVoltage().getValue());
//   }
// }

