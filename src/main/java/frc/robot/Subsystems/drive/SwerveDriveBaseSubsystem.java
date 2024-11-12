package frc.robot.Subsystems.drive;
import com.ctre.phoenix6.controls.CoastOut;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveDriveBaseSubsystem extends SubsystemBase {
    private final SwerveDriveOdometry m_odometry;
    private final SwerveModule frontLeftModule;
    private final SwerveModule frontRightModule;
    private final SwerveModule backLeftModule;
    private final SwerveModule backRightModule;
    private final AHRS ahrs;

    public void zeroYaw() {
        ahrs.zeroYaw();
    }

    public double getYaw() { 
        return -ahrs.getYaw();
    }

    public double getPitch() {
        return ahrs.getPitch();
    }

    public double getRoll() {
        return ahrs.getRoll();
    }

    public SwerveDriveBaseSubsystem() {
        frontLeftModule = new SwerveModule(SwerveConstants.frontLeft.turnMotorID, SwerveConstants.frontLeft.driveMotorID, SwerveConstants.frontLeft.turnEncoderID, SwerveConstants.frontLeft.offset);
        frontRightModule = new SwerveModule(SwerveConstants.frontRight.turnMotorID, SwerveConstants.frontRight.driveMotorID, SwerveConstants.frontRight.turnEncoderID, SwerveConstants.frontRight.offset);
        backLeftModule = new SwerveModule(SwerveConstants.backLeft.turnMotorID, SwerveConstants.backLeft.driveMotorID, SwerveConstants.backLeft.turnEncoderID, SwerveConstants.backLeft.offset);
        backRightModule = new SwerveModule(SwerveConstants.backRight.turnMotorID, SwerveConstants.backRight.driveMotorID, SwerveConstants.backRight.turnEncoderID, SwerveConstants.backRight.offset);
        ahrs = new AHRS(SerialPort.Port.kMXP);
        ahrs.zeroYaw(); 
        m_odometry = new SwerveDriveOdometry(Constants.SwerveConstants.m_SwerveDriveKinematics, ahrs.getRotation2d(), getPositions());
        coast();
    }

    public void brake() {
        frontLeftModule.configNeutralMode(NeutralModeValue.Brake);
        frontRightModule.configNeutralMode(NeutralModeValue.Brake);
        backLeftModule.configNeutralMode(NeutralModeValue.Brake);
        backRightModule.configNeutralMode(NeutralModeValue.Brake);
    }

    public void coast() {
        frontLeftModule.configNeutralMode(NeutralModeValue.Coast);
        frontRightModule.configNeutralMode(NeutralModeValue.Coast);
        backLeftModule.configNeutralMode(NeutralModeValue.Coast);
        backRightModule.configNeutralMode(NeutralModeValue.Coast);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Yaw", getYaw());
        frontLeftModule.outputDashboard();
        frontRightModule.outputDashboard();
        backLeftModule.outputDashboard();
        backRightModule.outputDashboard();
        m_odometry.update(getRotation2d(), getPositions());
    }

    public boolean reachedDist(double meters) {
        return
                (frontLeftModule.reachedDist(meters)) &&
                        (frontRightModule.reachedDist(meters)) &&
                        (backLeftModule.reachedDist(meters)) &&
                        (backRightModule.reachedDist(meters));
    }

    public void resetDriveEnc() {
        frontLeftModule.resetDriveEncoder();
        frontRightModule.resetDriveEncoder();
        backLeftModule.resetDriveEncoder();
        backRightModule.resetDriveEncoder();
    }

    public Rotation2d getRotation2d() {
        return ahrs.getRotation2d();
    }

    public SwerveModulePosition[] getPositions() {
        return new SwerveModulePosition[]{frontLeftModule.getPose(), frontRightModule.getPose(), backLeftModule.getPose(), backRightModule.getPose()};
    }

    public void stop() {
        frontLeftModule.stop();
        frontRightModule.stop();
        backLeftModule.stop();
        backRightModule.stop();
    }

    public Pose2d getPose() {
        return m_odometry.getPoseMeters();
    }

    public void resetOdometry(Pose2d pose) {
       m_odometry.resetPosition(ahrs.getRotation2d(), getPositions(), pose);
    }

    public ChassisSpeeds getChassisSpeedsFromJoystick(double vx, double vy, double rx, boolean slowMode) {
        vx = Math.abs(vx) > 0.05 ? -vx * SwerveConstants.kMaxTranslationalSpeed : 0;
        vy = Math.abs(vy) > 0.05 ? vy * SwerveConstants.kMaxTranslationalSpeed : 0;
        rx = Math.abs(rx) > 0.05 ? -0.7 * rx * SwerveConstants.kMaxRotationalSpeed : 0;
        if (slowMode) {
            vx *= 0.2;
            vy *= 0.2;
            rx *= 0.2;
        }
        return ChassisSpeeds.fromFieldRelativeSpeeds(vx, vy, rx, getRotation2d());
    }

    public void setModuleStates(SwerveModuleState[] moduleStates) {
        frontLeftModule.setSwerveModuleState(moduleStates[0]);
        frontRightModule.setSwerveModuleState(moduleStates[1]);
        backLeftModule.setSwerveModuleState(moduleStates[2]);
        backRightModule.setSwerveModuleState(moduleStates[3]);
    }

    public void setModuleStates(ChassisSpeeds chassisSpeeds) {
        setModuleStates(Constants.SwerveConstants.m_SwerveDriveKinematics.toSwerveModuleStates(chassisSpeeds));
    }
}
