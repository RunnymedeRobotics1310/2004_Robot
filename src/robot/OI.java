package robot;

import com.toronto.oi.T_Axis;
import com.toronto.oi.T_Button;
import com.toronto.oi.T_Logitech_GameController;
import com.toronto.oi.T_OiController;
import com.toronto.oi.T_Stick;
import com.toronto.oi.T_Toggle;
import com.toronto.oi.T_Trigger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private T_OiController driverController = new T_Logitech_GameController(0);

	private T_Toggle holdBallToggle = new T_Toggle(driverController, T_Button.RIGHT_BUMPER, true);
	private T_Toggle getButtonArmToggle = new T_Toggle(driverController, T_Button.LEFT_BUMPER, true);

	/*
	 * ************************************************************************
	 * Drive Speed and Turn
	 **************************************************************************/

	public double getSpeed() {
		double speed = driverController.getAxis(T_Stick.LEFT, T_Axis.Y);
		// Square the speed to reduce sensitivity & keep the sign
		return speed * Math.abs(speed);
	}

	public double getTurn() {
		double turn = driverController.getAxis(T_Stick.LEFT, T_Axis.X);
		// Square the turn to reduce sensitivity & keep the sign
		return turn * Math.abs(turn);
	}

	public boolean getLeftSideFlap() {
		return driverController.getButton(T_Button.X);
	}

	public boolean getRightSideFlap() {
		return driverController.getButton(T_Button.B);
	}

	public boolean getHoldBall() {
		return holdBallToggle.getToggleState();
		// return driverController.getButton(T_Button.RIGHT_BUMPER);
	}

	public boolean getButtonArm() {
		return getButtonArmToggle.getToggleState();
		// return driverController.getButton(T_Button.LEFT_BUMPER);
	}

	public double getArmMotor() {
		double speed = driverController.getAxis(T_Stick.RIGHT, T_Axis.Y);
		return speed * Math.abs(speed);
	}

	public void updatePeriodic() {

		// Update the toggle
		holdBallToggle.update();
		getButtonArmToggle.update();

		// Update the joysticks
		SmartDashboard.putString("Driver Controller", driverController.toString());

	}

}
