package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ArmFeedforward;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;



public class SetArmToPoint extends CommandBase {
   private final ArmSubsystem armSubsystem;
   private final double setPoint;
   private final PIDController pidController = new PIDController(1.0,0.0,0.1);
   private final ArmFeedforward feedforward = new ArmFeedforward(0.0,1.0,0.5,0.1);




 public SetArmToPoint (ArmSubsystem armSubsystem, double setPoint) {
   this.armSubsystem = armSubsystem;
   this.setPoint = setPoint;   
 }


 // Called when the command is initially scheduled.
 @Override
 public void initialize() {
   armSubsystem.coast();
   armSubsystem.runMotor(0);
   pidController.setTolerance(5,10);
   pidController.setSetpoint(setPoint);
  
 }


 // Called every time the scheduler runs while the command is scheduled.
 @Override
 public void execute() {
   double currentPosiiton = armSubsystem.getPosition();
   double ff = feedforward.calculate(currentPosition,setPoint); //feedforward, ask lead`
   double pidValue = pidController.calculate(currentPosition);
   armSubsystem.runMotor(pidValue+ff);
   //pid value+ feedForward
  
 }


 // Called once the command ends or is interrupted.
 @Override
 public void end(boolean interrupted) {
   armSubsystem.runMotor(0);
   armSubsystem.brake();
  
 }


 // Returns true when the command should end.
 @Override
 public boolean isFinished() {
   return pidController.atSetpoint();
   //at the desired point
 }
}


