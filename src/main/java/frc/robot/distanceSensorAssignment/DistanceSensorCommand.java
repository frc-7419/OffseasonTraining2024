// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.distanceSensorAssignment;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.ArmSubsystem;
import frc.robot.Subsystems.DistanceSensorSubsystem;

import com.revrobotics.Rev2mDistanceSensor;
import com.revrobotics.Rev2mDistanceSensor.Port;


public class DistanceSensorCommand extends Command {
  private final ArmSubsystem armSubsystem;
  private final DistanceSensorSubsystem distanceSensorSubsystem;
  private final XboxController xboxController;
  public DistanceSensorCommand(ArmSubsystem armSubsystem, XboxController xboxController, DistanceSensorSubsystem distanceSensorSubsystem) {
    this.armSubsystem = armSubsystem;
    this.distanceSensorSubsystem = distanceSensorSubsystem;
    this.xboxController = xboxController;
    addRequirements(armSubsystem);
    addRequirements(distanceSensorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  //putting a distance sensor on the arm and if the sensor is detecting something, it brakes the arm to prevent arm from hitting something
  @Override
  public void execute() {
    if (xboxController.getAButtonPressed() && distanceSensorSubsystem.getRange()>=0.2) { //not sure what the range is for dist xmp
      armSubsystem.runMotor(0.9);
    }else if(xboxController.getBButtonPressed() &&  distanceSensorSubsystem.getRange()>=0.2){
      armSubsystem.runMotor(-0.9);
    }else{
      armSubsystem.brake();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
