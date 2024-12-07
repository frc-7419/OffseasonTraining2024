package frc.robot.commands;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class SetArmToPoint extends Command{
   private final ArmSubsystem armSubsystem;
   private double setPoint;
   private final PIDController pidController = new PIDController(1.0,0.0,0.1);
   private final ArmFeedforward feedforward = new ArmFeedforward(0.0,1.0,0.5,0.1);

 public SetArmToPoint (ArmSubsystem armSubsystem, double setPoint) {
   this.armSubsystem = armSubsystem;
   this.setPoint = setPoint;   
 }


 // Called when the command is initially scheduled.
 public void initialize() {
  armSubsystem.coast();
   armSubsystem.runMotor(0);
   pidController.setTolerance(5,10);
   pidController.setSetpoint(setPoint);
  
 }


 // Called every time the scheduler runs while the command is scheduled.
 public void execute() {
   double currentPosition = armSubsystem.getPosition();
   double ff = feedforward.calculate(currentPosition,setPoint); //feedforward, ask lead`
   double pidValue = pidController.calculate(currentPosition);
   armSubsystem.runMotor(pidValue+ff);
   //pid value+ feedForward
  
 }


 public void end(boolean interrupted) {
   armSubsystem.runMotor(0);
   armSubsystem.brake();
  
 }


 public boolean isFinished() {
   return pidController.atSetpoint();
   //at the desired point
 }
}


