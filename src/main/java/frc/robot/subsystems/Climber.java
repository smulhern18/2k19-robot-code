/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
    private static Climber climber;

    private AnalogInput chassisACS;
    private final int CHASSIS_ACS_PORT = 3;

    private DigitalInput trolleyUp, armsDown;
    private final int TROLLEY_PORT = 0, ARMS_PORT = 1;

    private WPI_TalonSRX motor;
    private final int MOTOR_PORT = 18;

    private Servo servo;
    private final int SERVO_PORT = 1;

    private DoubleSolenoid solenoid;
    private final int SOLENOID_FORWARD_PORT = 4, SOLENOID_REVERSE_PORT = 5;
    private boolean climbPressed;

    private Climber() {
        climbPressed = false;
        chassisACS = new AnalogInput(CHASSIS_ACS_PORT);

        trolleyUp = new DigitalInput(TROLLEY_PORT);
        armsDown = new DigitalInput(ARMS_PORT);

        motor = new WPI_TalonSRX(MOTOR_PORT);
        servo = new Servo(SERVO_PORT);

        solenoid = new DoubleSolenoid(SOLENOID_FORWARD_PORT, SOLENOID_REVERSE_PORT);
    }

    public double getChassisACS() {
        return chassisACS.getVoltage();
    }

    /**
     * Value between 0 and 1
     */
    public void setServo(double value) {
        servo.set(value);
    }

    public double getServoValue() {
        return servo.get();
    }

    public void setClimbPressed() {
        climbPressed = true;
    }

    public boolean getClimbPressed() {
        return climbPressed;
    }

    // TODO: find the real threshold
    public boolean isChassisACSTriggered() {
        return chassisACS.getVoltage() > 1.5;
    }

    public boolean isTrolleyUp() {
        return trolleyUp.get();
    }

    public boolean isArmsDown() {
        return armsDown.get();
    }

    public void setSpeed(ControlMode mode, double speed) {
        motor.set(mode, speed);
    }

    public void setSolenoid(boolean state) {
        DoubleSolenoid.Value value;
        if (state)
            value = Value.kForward;
        else
            value = Value.kReverse;

        solenoid.set(value);
    }

    @Override
    public void initDefaultCommand() {
    }

    public static Climber getInstance() {
        if (climber == null)
            climber = new Climber();
        return climber;
    }

    public enum Direction {
        FORWARD(1), BACKWARD(-1);

        private final int value;

        private Direction(int value) {
            this.value = value;
        }

        public int get() {
            return value;
        }
    }
}
