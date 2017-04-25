package robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int LEFT_MOTOR_PWM_PORT = 1;
	public static final int RIGHT_MOTOR_PWM_PORT = 0;
	
	public static final int ARM_MOTOR_PWM_PORT = 2;
	
	public static final int ARM_TOP_SOLENOID = 1;
	public static final int ARM_BOTTOM_SOLENOID = 2;
	
	public static final int LEFT_FLAPPY_SOLENOID_A = 0;
	public static final int LEFT_FLAPPY_SOLENOID_B = 7;
	public static final int RIGHT_FLAPPY_SOLENOID = 3;
}
