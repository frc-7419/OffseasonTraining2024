// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivebaseSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ProjectileFirer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class MapleAuton extends SequentialCommandGroup {
  /** Creates a new MapleAuton. */
  public MapleAuton(IntakeSubsystem ARM, ProjectileFirer Nanahira, DrivebaseSubsystem Camellia) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new FireProjectile(Nanahira), new WaitCommand(1), new SetSwerveSpeed(Camellia, 0.5, 0), 
     new WaitCommand(1), new SetSwerveSpeed(Camellia, 0, 0), new PickUpNote(ARM), new FireProjectile(Nanahira));
    
}
