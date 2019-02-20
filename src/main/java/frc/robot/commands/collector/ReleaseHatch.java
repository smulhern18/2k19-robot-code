/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.collector;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ReleaseHatch extends CommandGroup {
    /**
     * Add your docs here.
     */
    public ReleaseHatch() {
        addSequential(new OpenCollector());
        addSequential(new WaitCommand(.75));
        addSequential(new ExtakeHatchPanel());
        addSequential(new WaitCommand(.5));
        addSequential(new RetractHatchCylinder());

    }
}
