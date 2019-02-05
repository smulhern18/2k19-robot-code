/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.subsystems.Drivetrain;

public class DriveFeet extends PIDCommand {
    Drivetrain drive = Drivetrain.getInstance();
    static final double P = 0.0, I = 0.0, D = 0.0;

    public DriveFeet(double feet) {
        super(P, I, D);
        requires(drive);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }

    @Override
    protected double returnPIDInput() {
        return (drive.getLeftPosition() +drive.getRightPosition())/2.00;
    }

    @Override
    protected void usePIDOutput(double output) {
        drive.drive(output, output);
    }
}
