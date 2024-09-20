// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExampleCommand extends CommandBase {
  private final ArmSubsystem armSubsystem;
  private final CommandXboxController joystick;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(ArmSubsystem armSubsystem,CommandXboxController joystick) {
    this.armSubsystem = armSubsystem;
    this.joystick = joystick;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.coast();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    armSubsystem.runMotor(joystick.getLeftY());
    
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


// package frc.robot.commands;
// import com.ctre.hardware.phoenix6;
// import com.ctre.signals.phoenix6;
// import edu.wpilibj.command.Commands;
// import frc.robot.subsystems.ArmSubsystem;
// import frc.edu.wpilibj2.command.button.CommandXboxController;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// public class RunArmWithJoystick extends CommandBase {
//   private final ArmSubsystem armSubsystem;
//   private final CommandXboxController joystick;

//   /**
//    * Creates a new ExampleCommand.
//    *
//    * @param subsystem The subsystem used by this command.
//    */
//   public RunArmWithJoystick(ArmSubsystem armSubsystem,CommandXboxController joystick) {
//     this.armSubsystem =  armSubsystem;
//     this.joystick = joystick;
//     addRequirements(armSubsystem);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     armSubsystem.coast();
    
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     armSubsystem.runMotor(joystick.getLeftY());
    
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     armSubsystem.brake();
    
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }



// package frc.robot.commands;
// import frc.robot.subsystems.ArmSubsystem;
// import frc.robot.Joystick;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// public class RunArmWithJoystick extends CommandBase {
//   private final ArmSubsystem armSubsystem;
//   private final Joystick joystick;

//   /**
//    * Creates a new ExampleCommand.
//    *
// //    * @param subsystem The subsystem used by this command.
//    */
//   public RunArmWithJoystick() {
//     this.armSubsystem = new ArmSubsystem;
//     addRequirements(subsystem);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     armSubsystem.coast();
    
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     armSubsystem.runMotor(Joystick.getLeftY());

    
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     ArmSubsystem.brake();
    
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }

// package frc.robot.commands;
// import frc.subsystems.ArmSubsystem;
// import edu.first.wpilij.command.Commands;
// import frc.robot.subsystems.ArmSubsystem;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Joystick;

// public class RunArmWithJoystick extends CommandBase {
//   private final ArmSubsystem armSubsystem;
//   private final CommandXboxController xboxcontroller;


//   /**
//    * Creates a new ExampleCommand.
//    *
//    * @param subsystem The subsystem used by this command.
//    */
//   public RunArmWithJoystick() {
//     this.armSubsystem = new ArmSubsystemee;
    
//     addRequirements(subsystem);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     armSubsystem.coast();
    
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     armSubsystem.runMotor();
    
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     armSubsystem.brake();
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }


// package frc.robot.commands;
// import frc.robot.subsystems.ArmSubsystem;
// import edu.wpi.first.wpilij.command.Command;
// import edu.wpi.first.wpilij.command.button.CommandXboxController;
// public class RunArmWithJoystick(){
//   private final ArmSubsystem armSubsystem;
//   public RunArmWithJoystick(){
//     this.armSubsystem = new ArmSubsystem;

//   }
//   @Override;
//   public void initialize(){
//     armSubsystem.coast();

//   }
//   public void execute(){
//     armSubsystem.runMotor();

//   }
//   public void end(boolean interrupted){
//     armSubstem.brake();
//   }
//   public void isFinished(){
//     return false;
//   }
// }

// package frc.robot.commands;
// import frc.robot.subsystems.ArmSubsystem;
// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

// public class RunArmWithJoystick extends Command {
//   private final ArmSubsystem armSubsystem;
//   private final double power;
//   private final CommandXboxController joystick;
//   /** Creates a new RunArm. */
//   public RunArmWithJoystick(ArmSubsystem armSubsystem,CommandXboxController joystick) {
//     this.armSubsystem = armSubsystem;
//     this.joystick = joystick;
//     addRequirements(armSubsystem); //command accquires subsystem

//     // Use addRequirements() here to declare subsystem dependencies.
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     armSubsystem.coast();
    

//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     armSubsystem.runMotor(joystick.getLeftY());
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     armSubsystem.brake();
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
