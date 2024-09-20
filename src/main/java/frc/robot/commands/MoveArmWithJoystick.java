// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class MoveArmWithJoystick extends Command {
  /** Creates a new MoveArmWithJoystick. */
  private final Joystick joystick;
  private final XboxController xboxController;
  private final ArmSubsystem armSubsystem;

  public MoveArmWithJoystick() {
    // Use addRequirements() here to declare subsystem dependencies.
    this.joystick = new Joystick(0);
    this.armSubsystem = new ArmSubsystem();
    this.xboxController = new XboxController(0);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (joystick.getRawButtonPressed(0))
    {
      armSubsystem.runMotor(0.5, false);
    }
    else{
      armSubsystem.brake();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
