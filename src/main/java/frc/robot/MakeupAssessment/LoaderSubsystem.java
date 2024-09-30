public class LoaderSubsystem extends SubsystemBase{
    private final TalonFX TopLoader;
    private final TalonFX BottomLoader;

    public LoaderSubsystem(){
        this.TopLoader = new TalonFX(2);
        this.BottomLoader = new TalonFX(3);
    }

    public void coast(){
        TopLoader.setNeutralMode(NeutralModeValue.Coast);
        BottomLoader.setNeutralMode(NeutralModeValue.Coast);
    }
    public void brake(){
        TopLoader.setNeutralMode(NeutralModeValue.Brake);
        BottomLoader.setNeutralMode(NeutralModeValue.Brake);
    }
    
    public void setTopPower(double power){
        TopLoader.setPower(power);
    }
    public void setBottomPower(double power){
        TopLoader.setPower(power);
    }

}
