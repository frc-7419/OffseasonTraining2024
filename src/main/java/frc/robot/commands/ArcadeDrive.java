package frc.robot.commands;
public class ArcadeDrive extends CommandBase {
    

    private final DriveBaseSubsystem driveBaseSubsystem;
    private final XboxController controller;

    public ArcadeDrive(DriveBaseSubsystem driveBaseSubsystem, XboxController controller) {
        this.driveBaseSubsystem = driveBaseSubsystem;
        this.controller = controller;
        addRequirements(driveBaseSubsystem);
    }

    @Override
    public void execute() {
        //*0.7 so more control and not that agressive, - for y axis because it's flipped */
        double forward = -controller.getLeftY()*0.7;
        double rotation = controller.getRightX()*0.7;

        driveBaseSubsystem.runMotor(forward + rotation, forward - rotation);
    }

    @Override
    public void end(boolean interrupted) {
        driveBaseSubsystem.brake();
    }
}