package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArcadeDrive;

public class TranslateDistance extends Command {
    private final ArcadeDrive drive;
    private final double distance;
    private double initialPosition;
    private boolean isFinished;

    public TranslateDistance(ArcadeDrive drive, double distance) {
        this.drive = drive;
        this.distance = distance;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        initialPosition = drive.getCurrentPosition();
        isFinished = false;
    }

    @Override
    public void execute() {
        double currentPosition = drive.getCurrentPosition();
        if (currentPosition - initialPosition < distance) {
            drive.setLeftRightPower(0.5, 0.5); 
        } else {
            isFinished = true; 
        }
    }

    @Override
    public void end(boolean interrupted) {
        drive.setLeftRightPower(0, 0); 
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
} 