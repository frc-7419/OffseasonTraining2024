package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ArmSubSystem;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;

public class SetArmSetpoint extends Command {
  /** Creates a new RunArmWithJoystick. */
  private final ArmSubSystem arm; //declare arm from arm subsytem
  private final CommandXboxController joystick; //declare joystick for this command
  private double setpoint;
  private final pidController = new PIDController(1.0, 0.0, 0.1);
  private final feedforward = new ArmFeedforward(0.0, 1.0, 0.5. 0.1);



public void SetArmSetpoint(ArmSubSystem arm, double setpoint, CommandXboxController joystick) { //dude i set it to void why is it not working 
    // Use addRequirements() here to declare subsystem dependencies.
    this.arm = arm; //the joystick for this class = the joystick in commandxbox controller
    this.joystick = joystick;
    this.setpoint = setpoint;
    addRequirements(arm); //dont forget
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize(PIDController pidController) {
    arm.coast();
    arm.set(pid.calculate(encoder.getDistance()), setpoint);
    pidController.setGoal(setpoint);
    pidController.setTolerance(ArmConstants.SetpointThreshold);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double position =  arm.getPosition();
    ArmFeedforward feedforward;
    double ff = feedforward.calculate(position, setpoint);
    double pid = pidController.calculate(position);

    arm.runMotor(joystick.getLeftY()); //gets a y value on the joystick in percent to move the motor
    if (joystick.leftBumper().getAsBoolean()) {
      arm.brake();
    } //brakes arm of the right bumper is clicker.
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.setPower(0);
    arm.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return armPIDController.atGoal();
  }
}
//i think something went wrong with my imports why is there so much red