package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.GyroSubsystem;

public class RunGyroWithXBoxController extends CommandBase {
  private final GyroSubsystem gyroSubsystem;
  private final CommandXboxController commandXboxController;

  /** Creates a new RunGyroWithXBoxController. */
  public RunGyroWithXBoxController(GyroSubsystem gyroSubsystem, CommandXboxController commandXboxController) {
    this.gyroSubsystem = gyroSubsystem;
    this.commandXboxController = commandXboxController;
    addRequirements(gyroSubsystem);
  }

  @Override
  public void initialize() {
    commandXboxController.rightBumper().whileTrue(this);
  }

  @Override
  public void execute() {
    double yaw = gyroSubsystem.yawAHRS();
    double roll = gyroSubsystem.rollAHRS();
    double pitch = gyroSubsystem.pitchAHRS();

    SmartDashboard.putNumber("Gyro Yaw", yaw);
    SmartDashboard.putNumber("Gyro Roll", roll);
    SmartDashboard.putNumber("Gyro Pitch", pitch);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
  }
}
