package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
public class ArmSubsystem extends SubsystemBase {
    TalonFX MikuBondage;
    public ArmSubsystem() {
        super();
        MikuBondage = new TalonFX(0);
    }
    //Change Voltage
    public void changeVoltage(double newVoltage) {
        MikuBondage.setVoltage​(newVoltage);
    }
    //Coasting -
    public void coast() {
        MikuBondage.setNeutralMode(NeutralModeValue.valueOf("Coast"));
    }
    //Braking
    public void brake() {
        MikuBondage.setNeutralMode(NeutralModeValue.valueOf("Brake"));
    }
}
