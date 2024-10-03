package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDriveSubsystem;

public class StabilizeHeadingCommand extends Command {
  private final TankDriveSubsystem tankDriveSubsystem;
  private final double forwardSpeed;
  private final double kP = 1.0;  // Proportional control constant
  private double initialHeading;

  // Constructor to pass in the TankDriveSubsystem and desired forward speed
  public StabilizeHeadingCommand(TankDriveSubsystem tankDriveSubsystem, double forwardSpeed) {
    this.tankDriveSubsystem = tankDriveSubsystem;
    this.forwardSpeed = forwardSpeed;
    // Declare subsystem dependencies
    addRequirements();
  }

  // Called when the command is initially scheduled
  @Override
  public void initialize() {
    // Set the initial heading to the current gyro angle
    initialHeading = tankDriveSubsystem.getHeading();
  }

  // Called every time the scheduler runs while the command is scheduled
  @Override
  public void execute() {
    double error = initialHeading - tankDriveSubsystem.getHeading();
    double turnCorrection = kP * error;
    tankDriveSubsystem.tankDrive(forwardSpeed + turnCorrection, forwardSpeed - turnCorrection);
  }

  // Called once the command ends or is interrupted
  @Override
  public void end(boolean interrupted) {
    // Stop the robot when the command ends
    tankDriveSubsystem.tankDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;  // This command keeps running until interrupted
  }
}

/** STABALIZE HEADING COMMAND ONLY WORKS WITH SECOND VERSION OF TANK DRIVE SUBSYSTEM CODE */