public final shooterSubSystem extends SubsystemBase{
    private shooterMotor0 = new TalonFX(0);
    private shooterMotor1 = new TalonFX(1);
    private angleMotor = new TalonFX(2);
    private void angleController(double anglePower){
        angleMotor.runMotor(anglePower);
    }
    private void runMotor(double power){
            TalonFX.runMotor(power);
            TalonFX.brake();
            
        }
    private void coastMotor0(){
        shooterMotor0.setNeutralModeValue(Coast);


    }
    private void coast(){
        this.shooterMotor1.setNeutralModeValue(coast);
        this.shooterMotor0.setNeutralModeValue(coast);


    }
    private void brake(){
        this.shooterMotor1.setNeutralModeValue(brake);
        this.shooterMotor0.setNeutralModeValue(brake);

    }

    private void periodic(){
        SmartDashboard.putNumber("Shooter Motor 0's voltage" + shooterMotor0.getMotorVoltage.getValue());
        SmartDashboard.putNumber("Shooter Motor 1's voltage" + shooterMotor1.getMotorVoltage.getValue());

    }
}
    


}