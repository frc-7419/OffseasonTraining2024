package frc.robot.AssessmentOnePractice.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.AssessmentOnePractice.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.XboxController;
public class ShooterProjectile extends CommandBase {
    private final ShooterSubsystem shooterSubsystem;
    //no need to restate the motors in the subsystem
    private final XboxController xBoxController;
    public ShooterProjectile(ShooterSubsystem shooterSubsystem){
        this.shooterSubsystem = shooterSubsystem;
        this.xBoxController = new XboxController(0);

    }
    @Override
    public void initialize() {
      shooterSubsystem.coast();
      //test it out and pray
      
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      shooterSubsystem.runMotor(xBoxController.getLeftY());
      
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      shooterSubsystem.brake();
      
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }

    
}
