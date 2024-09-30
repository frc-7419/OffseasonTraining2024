public class IntakeSubsystem extends SubsystemBase{
    private TalonFX TopIntake;
    private TalonFX BottomIntake;

    public IntakeSubsystem(){
        this.TopIntake = new TalonFX(0);
        this.BottomIntake = new TalonFX(1);
    }
    public void coast(){
        TopIntake.setNeutralMode(NeutralModeValue.Coast);
        BottomIntake.setNeutralMode(NeutralModeValue.Coast);
    }
    public void brake(){
        TopIntake.setNeutralMode(NeutralModeValue.Brake);
        BottomIntake.setNeutralMode(NeutralModeValue.Brake);
    }

    public void setTopPower(double power){
        TopIntake.setPower(power);
    }
    public void setBottomPower(double power){
        BottomIntake.setPower(power);
    }

    public void periodic(){

    }
} 