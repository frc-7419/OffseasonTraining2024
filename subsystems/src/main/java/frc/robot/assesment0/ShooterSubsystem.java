// Pseudocode thing / Java thing
package frc.robot.subsystems; // Get the package with all the commands.

// requirments
// The shooter should be able to adjust its angle up and down.
// The shooter should be able to fire projectiles on command.

public class ExampleSubSystem extends shooterSubSystem {

    private TalonFX angleMotor; // For the motor that adjusts the angle of the shooter
    private TalonFX shootingMotor; // For the motors that do the shooting stuff

    public void angleAdjuster () {
        this.angleMotor = angleMotor;
    }
     
    public void setAngle (double angle) { // Declaring the variable to set the angle
        if (angle < 85) { // Making sure the angle is not more than 85°
            angleMotor.set(angle);
            System.out.println("Your shooter is at " angle + "°");
        } else {
            System.out.println("Your shooter is over 85°"); // Allows the user to know if there shooter is too far back
        }
    }

    public void joyStickAngle () { // To assign the right joystick to manage the angle of the shooter
        angleMotor.xboxRightJoystick();
    }

    public void shootingSpeed () { // Sets the motor speed for shooting
        this.shootingMotor = shootingMotor;
    }

    public void setSpeed (public double speed) { // Declaring the variable for the movement speed
        shootingMotor.set(speed);
    } 

    public void buttonShooting () { // To assign the left bumper for shooting
        shootingMotor.xboxLeftBumper();
    }

    public void iWantToShoot () {
        if (xboxLeftBumper()) { // Checks if left bumper is down
            //rev motor     // I don't know how to rev a motor
        } else { // We don't want the motor to keep running after we stop pressing
            speed = 0; // Sets the speed back to 0 so it stops revving
        }
    }
}