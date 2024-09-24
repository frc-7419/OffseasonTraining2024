// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.assesmentZeroRetakeGraded;

import edu.wpi.first.wpilibj.StadiaController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class BrehCommand extends Command {
  /** Creates a new BrehCommand. */
  private final CommandXboxController buttonCommandXboxController;
  private final CommandXboxController joystickCommandXboxController;
  private final BrehSubsystem shooterTopBrehSubsystem;
  private final BrehSubsystem shooterBotBrehSubsystem;
  private final BrehSubsystem intakeTopBrehSubsystem;
  private final BrehSubsystem intakeBotBrehSubsystem;
  public BrehCommand(BrehSubsystem shooterTop, BrehSubsystem intakeTop, BrehSubsystem intakeBot, 
  BrehSubsystem shooterBot, CommandXboxController joystick, CommandXboxController button) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterTopBrehSubsystem = shooterTop;
    this.shooterBotBrehSubsystem = shooterBot;
    this.intakeTopBrehSubsystem = intakeTop;
    this.intakeBotBrehSubsystem = intakeBot;
    this.joystickCommandXboxController = joystick;
    this.buttonCommandXboxController = button;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeTopBrehSubsystem.coastTheMotor();
    intakeBotBrehSubsystem.coastTheMotor();
    shooterBotBrehSubsystem.coastTheMotor();
    shooterTopBrehSubsystem.coastTheMotor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeTopBrehSubsystem.setPower(joystickCommandXboxController.getLeftY());
    intakeBotBrehSubsystem.setPower(joystickCommandXboxController.getLeftY());
    shooterBotBrehSubsystem.setPower(buttonCommandXboxController.leftBumper().getAsBoolean());
    shooterTopBrehSubsystem.setPower(buttonCommandXboxController.leftBumper().getAsBoolean());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeTopBrehSubsystem.brakeTheMotor();
    intakeBotBrehSubsystem.brakeTheMotor();
    shooterBotBrehSubsystem.brakeTheMotor();
    shooterTopBrehSubsystem.brakeTheMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
