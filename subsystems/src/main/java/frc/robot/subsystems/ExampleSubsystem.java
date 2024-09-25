package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.armSubsystem;

public class exampleSubsystem extends armSubsystem {
  /** Creates a new ExampleSubsystem. */
  private TalonFX armThing;
  public armSubsystem() {
    this.armThing = armThing;
  }
  public void setPower(double armPower) {
    armThing.set(armPower);
  }
  public void coast() {
    armThing.set(armPower);
  }
  public void brake() {
    armThing.set(armPower);
  }


  public void execute() {
    arm.setPower(0.9)
  }
  public class runArmWithJoystick () {

  }
  
  public void execute() {
    arm.setPower
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  private final Command runArmJoystick = new RunCommand()

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
