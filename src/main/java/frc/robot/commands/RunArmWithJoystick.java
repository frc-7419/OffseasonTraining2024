package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ArmSubsystem;

public class RunArmWithJoystick extends Command {
private final ArmSubsystem arm;
private final CommandXboxController joystick;

public RunArmWithJoystick(ArmSubsystem arm, CommandXboxController joystick) {
	this.arm = arm;

	this.joystick = joystick;
		addRequirements(arm);
	}

	@Override
	public void initialize() {
		arm.coast();
	}

	@Override
	public void execute() {
		arm.runMotor(joystick.getLeftY());
	}

	@Override
	public void end(boolean interrupted) {
		arm.brake();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
