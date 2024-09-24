// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.MakeUpAssessment0;

import edu.wpi.first.wpilibj2.command.Command;

public class RunIntake extends Command {
  /** Creates a new RunIntake. */
  private final IntakeSubSystem intakeMotor1;
  private final IntakeSubSystem intakeMotor2;
  private final CommandXboxController joystick;
  public RunIntake() {
    // Use addRequirements() here to declare subsystem dependencies.
    this.joystick = joystick;
    this.intakeMotor1 = intakeMotor1;
    this.intakeMotor2 = intakeMotor2;
    addRequirements(IntakeSubSystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeMotor1.coast()
    intakeMotor2.coast()

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeMotor1.runMotor(joystick.getLeftY())
    intakeMotor2.runMotor(joystick.getLeftY())
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if joystick.getRightBumper().getAsBoolean()
      intakeMotor1.brake()
      intakeMotor2.brake()
    

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
