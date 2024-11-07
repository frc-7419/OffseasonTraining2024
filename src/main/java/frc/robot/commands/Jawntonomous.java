// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ArmSubSystem;
import frc.robot.commands.SetArmSetpoint;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class JawntonomousReal extends SequentialCommandGroup {
  /** Creates a new JawntonomousReal. */
  public JawntonomousReal(ArmSubSystem arm) {
    Object drive;
    // Add your commands in the addCommands) call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ParallelCommandGroup(
       new SetArmSetpoint(arm, 100),
       
       
       


      ).withTimeout(5).deadlineWith(new WaitCommand(5).raceWith(new WaitCommand(5)))
      
    
    );
  }
}