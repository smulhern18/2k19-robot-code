/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.autonomous.LeftRocketAuto;
import frc.robot.commands.autonomous.RightRocketAuto;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Vision;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    // TODO: map out ports
    private static final String MANUAL = "Teleop";
    private static final String LEFT_ROCKET = "Left rocket";
    private static final String RIGHT_ROCKET = "Right rocket";
    private static Command autoCommand = null;
    private String autoSelected;
    private final SendableChooser<String> autoChooser = new SendableChooser<>();

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        OI.getInstance();
        Collector.getInstance();
        Drivetrain.getInstance();
        Elevator.getInstance();
        // Climber.getInstance();
        Vision.getInstance();
        autoChooser.setDefaultOption(MANUAL, MANUAL);
        autoChooser.addOption(LEFT_ROCKET, LEFT_ROCKET);
        autoChooser.addOption(RIGHT_ROCKET, RIGHT_ROCKET);
        SmartDashboard.putData("Autos", autoChooser);
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for
     * items like diagnostics that you want ran during disabled, autonomous,
     * teleoperated and test.
     *
     * <p>
     * This runs after the mode specific periodic functions, but before LiveWindow
     * and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable chooser
     * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
     * remove all of the chooser code and uncomment the getString line to get the
     * auto name from the text box below the Gyro
     *
     * <p>
     * You can add additional auto modes by adding additional comparisons to the
     * switch structure below with additional strings. If using the SendableChooser
     * make sure to add them to the chooser code above as well.
     */
    @Override
    public void autonomousInit() {
        autoSelected = autoChooser.getSelected();
        // System.out.println("Auto selected: " + m_autoSelected);
        switch (autoSelected) {
        case LEFT_ROCKET:
            autoCommand = new LeftRocketAuto();
            break;
        case RIGHT_ROCKET:
            autoCommand = new RightRocketAuto();
            break;
        default:
            // manual, just use joy sticks
            break;
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();

    }

    @Override
    public void teleopInit() {
        if (autoCommand != null)
            autoCommand.cancel();
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
        Scheduler.getInstance().run();
    }
}
