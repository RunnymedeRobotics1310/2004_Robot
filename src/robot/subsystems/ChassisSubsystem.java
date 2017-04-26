
package robot.subsystems;

import com.toronto.subsystems.T_Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import robot.RobotMap;
import robot.commands.DefaultDriveCommand;

public class ChassisSubsystem extends T_Subsystem {

	/* ****************************************************************************
	 * Hardware declarations
	 * 
	 * Declare all motors and sensors here
	 ******************************************************************************/
	private SpeedController leftMotor;
	private SpeedController rightMotor;
	private DoubleSolenoid leftFlapSolenoid;
	private Solenoid rightFlapSolenoid;
	private Solenoid armTopSolenoid;
	private Solenoid armBottomSolenoid;
	
	private SpeedController armMotor;


	public static final double AT_TOWER__ULTRASONIC_DISTANCE = 15.0; 
	
	public ChassisSubsystem() {
		
		// Use the CAN bus motor controllers and encoders
		leftMotor = new Victor(RobotMap.LEFT_MOTOR_PWM_PORT);
		rightMotor = new Victor(RobotMap.RIGHT_MOTOR_PWM_PORT);

		armMotor = new Victor(RobotMap.ARM_MOTOR_PWM_PORT);
		
		leftFlapSolenoid = new DoubleSolenoid(RobotMap.LEFT_FLAPPY_SOLENOID_A, RobotMap.LEFT_FLAPPY_SOLENOID_B);
		rightFlapSolenoid = new Solenoid(RobotMap.RIGHT_FLAPPY_SOLENOID);
		armTopSolenoid = new Solenoid(RobotMap.ARM_TOP_SOLENOID);
		armBottomSolenoid = new Solenoid(RobotMap.ARM_BOTTOM_SOLENOID);

		
		 rightMotor.setInverted(true);
		 leftMotor.setInverted(true);

	}

	/* *****************************************************************************
	 * Put methods for controlling this subsystem here.
	 * Call these from Commands.
	 ******************************************************************************/

	public void initDefaultCommand() {
		setDefaultCommand(new DefaultDriveCommand());
	}

	public void robotInit() {

	
	}
	
	public void setArmMotorSpeeds(double speed) {
		armMotor.set(speed);
	}
	
	public void setMotorSpeeds(double leftSpeed, double rightSpeed) {
			leftMotor .set(leftSpeed);
			rightMotor.set(rightSpeed);
	}

	public void openLeftFlap() { 
		leftFlapSolenoid.set(Value.kReverse);
	}

	public void closeLeftFlap() {
		leftFlapSolenoid.set(Value.kForward);
	}

	public void openRightFlap() {
		rightFlapSolenoid.set(false);
	}

	public void closeRightFlap() {
		rightFlapSolenoid.set(true);
	}

	public void openTopArm() {
		armTopSolenoid.set(false);
	}

	public void closeTopArm() {
		armTopSolenoid.set(true);
	}

	public void openBottomArm() {
		armBottomSolenoid.set(false);
	}

	public void closeBottomArm() {
		armBottomSolenoid.set(true);
	}

	/* ****************************************************************************
	 * Update the Dashboard
	 ******************************************************************************/
	@Override
	public void updatePeriodic() {

		
		
	}

}

