// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RunArmWithJoystick extends Command {
  /** Creates a new RunArmWithJoystick. */
  private CommandXboxController joystick;
  private ArmSubsystem armSubsystem;
  public RunArmWithJoystick(CommandXboxController joystick, ArmSubsystem armSubsystem) {
    this.joystick = joystick;
    this.armSubsystem = armSubsystem;
    addRequirements(armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.setVoltage(0);
    armSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double joystickValue = joystick.getRightY();
    armSubsystem.setVoltage(joystickValue);
    SmartDashboard.putNumber("joystick value", joystickValue);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.setVoltage(0);
    armSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
