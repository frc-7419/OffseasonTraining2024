public class IntakeControl extends Command{
    private IntakeSubsystem intake = new IntakeSubsystem();
    private final CommandXboxController joystick;
    public IntakeControl(){
        this.joystick = joystick;
        this.intake = intake;
        addRequirements(intake);
    }


    @Override
    public void initialize(){
        intake.coast();
    }

    @Override
    public void execute(){
        double power = joystick.getLeftY();
        intake.setTopPower(power);
        intake.setBottomPower(power);
    }
    
    @Override
    public void end(){
        intake.brake();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
