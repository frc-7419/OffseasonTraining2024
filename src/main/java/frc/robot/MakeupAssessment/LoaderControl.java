public class LoaderControl extends Command{
    private LoaderSubsystem loader;
    private CommandXboxController joystick;
    public LoaderControl(){
        this.joystick = joystick;
        this.loader = loader;
        addRequirements(loader);
    }

    @Override
    public void initialize(){
        loader.coast();
    }

    @Override
    public void execute(){
        double power = joystick.getRightY();
        loader.setTopPower(power);
        loader.setBottomPower(power);
    }
    @Override
    public void end(){
        loader.brake();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
