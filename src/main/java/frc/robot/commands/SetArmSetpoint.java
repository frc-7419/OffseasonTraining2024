package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubSystem;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;


public class SetArmSetpoint extends Command {
  /** Creates a new RunArmWithJoystick. */
  private  ArmSubSystem armSubSystem; //declare arm from arm subsytem
  //declare joystick for this command
  private double setpoint;
  private final PIDController armPidController = new PIDController(1.0, 0.0, 0.1);
  private final ArmFeedforward feedForward = new ArmFeedforward(0.0, 1.0, 0.5, 0.1);
  



public void SetArmSetpoint(ArmSubSystem arm, double setpoint) { //dude i set it to void why is it not working 
    // Use addRequirements() here to declare subsystem dependencies.
    this.armSubSystem = arm; //the joystick for this class = the joystick in commandxbox controller
    this.setpoint = setpoint;
    addRequirements(armSubSystem); //dont forget
  }

  // Called when the command is initially scheduled.
  
  public void initialize() {
    armSubSystem.coast();
    armPidController.setSetpoint(setpoint);
    armSubSystem.set(armPidController.calculate(armSubSystem.getPosition()));
    armPidController.setTolerance(10);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double position =  armSubSystem.getPosition();

    double ff = feedForward.calculate(position, setpoint);
    double pid = armPidController.calculate(position);

    armSubSystem.set(pid); //gets a y value on the joystick in percent to move the motor

    } //brakes arm of the right bumper is clicker.
      
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubSystem.set(0);
    armSubSystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return armPidController.atSetpoint();
  }
}
//i think something went wrong with my imports why is there so much red