package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.ArmSubsystem;
import frc.robot.assessmentZeroSol.ShooterSubsystem;
import frc.robot.assessmentZeroSol.ShooterWristSubsystem;
import frc.robot.makeupAssessmentSol.IntakeSubsystem;


public class TwoNoteAuton extends SequentialCommandGroup {
    
    private final ShooterSubsystem shooterSubsystem;
    private final ShooterWristSubsystem shooterWristSubsystem;
    private final IntakeSubsystem intakeSubsystem;
    private final CommandSwerveDrivetrain drivetrain;

    public TwoNoteAuton(ShooterSubsystem shooterSubsystem, ShooterWristSubsystem shooterWristSubsystem, IntakeSubsystem intakeSubsystem, CommandSwerveDrivetrain drivetrain) {}
      // addCommands()
      // Called when the command is initially scheduled.
      @Override
      public void initialize() {}
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {}
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {}
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return false;
    }
}
