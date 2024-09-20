// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class RunArmWithJoystick extends Command {
  /** Creates a new RunArmWithJoystick. */
  private final ArmSubSystem arm; //declare arm from arm subsytem
  private final CommandXboxController joystick; //declare joystick for this command

  public RunArmWithJoystick(ArmSubSystem arm, CommandXboxController joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.arm = arm; //the joystick for this class = the joystick in commandxbox controller
    this.joystick = joystick;
    addRequirements(arm); //dont forget
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.runMotor(joystick.getLeftY()); //gets a y value on the joystick in percent to move the motor
    if joystick.leftBumper().getAsBoolean(): //brakes arm of the right bumper is clicker.
      arm.Brake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
