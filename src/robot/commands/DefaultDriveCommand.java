
package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.Robot;

/**
 * Drive command handles all commands related to driving Such as resetting
 * encoders and driving straight
 */
public class DefaultDriveCommand extends Command {

	enum ButtonState {
		PRESSED, RELEASED
	};

	ButtonState driveStraightState = ButtonState.RELEASED;
	

	public DefaultDriveCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassisSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		
		// Left side flap
		if (Robot.oi.getLeftSideFlap()) {
			Robot.chassisSubsystem.openLeftFlap();
		} else {
			Robot.chassisSubsystem.closeLeftFlap();
		}
		
		// Right side flap
		if (Robot.oi.getRightSideFlap()) {
			Robot.chassisSubsystem.openRightFlap();
		} else {
			Robot.chassisSubsystem.closeRightFlap();
		}
		
		// Hold the ball
		if (Robot.oi.getHoldBall()) {
			Robot.chassisSubsystem.openTopArm();
		} else {
			Robot.chassisSubsystem.closeTopArm();
		}
		
		// Button arm
		if(Robot.oi.getButtonArm()) {
			Robot.chassisSubsystem.openBottomArm();
		} else {
			Robot.chassisSubsystem.closeBottomArm();
		}
		
		// Robot arm motors
		double armMotorSpeed = Robot.oi.getArmMotor();
		
		if (Math.abs(armMotorSpeed) <= 0.2) {
			armMotorSpeed = 0;
		}
		
		SmartDashboard.putNumber("Arm Speed", armMotorSpeed);
		Robot.chassisSubsystem.setArmMotorSpeeds(armMotorSpeed);
		
		
		// Drive train
		double speed = Robot.oi.getSpeed();
		if (Math.abs(speed) <= .02) {
			speed = 0;
		}

		double turn = Robot.oi.getTurn();
		if (Math.abs(turn) <= .02) {
			turn = 0;
		}

		double leftSpeed = 0.0;
		double rightSpeed = 0.0;

		
		if (speed == 0.0) {
			leftSpeed = turn;
			rightSpeed = -turn;
		} else {
			if (speed > 0) {
				if (turn == 0) {
					leftSpeed = speed;
					rightSpeed = speed;
				} else if (turn < 0) {
					rightSpeed = speed;
					leftSpeed = (1.0 + turn) * speed;
				} else if (turn > 0) {
					leftSpeed = speed;
					rightSpeed = (1.0 - turn) * speed;
				}
			}
			if (speed < 0) {
				if (turn == 0) {
					leftSpeed = speed;
					rightSpeed = speed;
				} else if (turn < 0) {
					rightSpeed = (1.0 + turn) * speed;
					leftSpeed = speed;
				} else if (turn > 0) {
					leftSpeed = (1.0 - turn) * speed;
					rightSpeed = speed;
				}

			}
		}

		// Move the motors at half the speed because the robot is old.... like really really old....
		leftSpeed *= 0.5;
		rightSpeed *= 0.5;

		SmartDashboard.putNumber("Robot Speed", (leftSpeed + rightSpeed) / 2);

		Robot.chassisSubsystem.setMotorSpeeds(leftSpeed, rightSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
