package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first. wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.AssessmentOnePractice.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.ArmSubsystem;

public class Auton extends SequentialCommandGroup {
    public Auton(ArmSubsystem armMotor, ArcadeDrive driveBaseSubsystem){
        addCommands(
            new ParallelCommandGroup(
            new SetArmToPoint(armMotor,100),
            new ArcadeDrive(driveBaseSubsystem,10)

            ).withTimeout(5).deadlineWidth(new WaitCommand(5).raceWidth(new WaitCommand(5))));
            //waitcommand, waits for it to finish,sequential,block coding, if interrupt, stops commmand
            //wait to finish first
            //deadline widt
        
        // addCommands(new SetArmToPoint(arm,100));
    }

}
