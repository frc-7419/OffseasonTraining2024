package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first. wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ArmSubsystem;

public class Auton extends SequentialCommandGroup {
    public Auton(ArmSubsystem arm){
        addCommands(
            new ParallelCommandGroup(
            new SetArmToPoint(arm,100),
            new ArcadeDrive(drive,10)

            ).withTimeout(5).deadlineWidth(new WaitCommand(5).raceWidth(new WaitCommand(5))));
            //waitcommand, waits for it to finish,sequential,block coding, if interrupt, stops commmand
            //wait to finish first
            //deadline widt
        
        // addCommands(new SetArmToPoint(arm,100));
    }

}
