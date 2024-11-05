package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystem.ArmSubsystem;

public class Jawntonmous extends SequentialCommandGroup{
    public Jawntonmous (ArmSubsystem arm){
        addCommands(
            newParallelCommandGroup(
                new SetArmToPoint(arm, setPoint:100)
                new ArcadeDrive(drive, distance:10)
                //Another way to add 5 seonds ---- new WaitCommand(seconds:5) ------


            ).withTimeout(5).deadlineWith(new WaitCommand(seconds:5)).raceWith(new WaitCommand(seconds:5))

        );
    }
}