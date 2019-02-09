/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.climber.Climb;
import frc.robot.commands.climber.RollManual;
import frc.robot.commands.collector.AutoCargoCollect;
import frc.robot.commands.collector.CloseCollector;
import frc.robot.commands.collector.ExtakeHatchPanel;
import frc.robot.commands.collector.OpenCollector;
import frc.robot.commands.collector.RollIntakeForCargo;
import frc.robot.commands.elevator.ElevateManual;
import frc.robot.commands.elevator.ElevateToHeight;
import frc.robot.input.AttackThree;
import frc.robot.input.ButtonBox;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Collector.Speed;
import frc.robot.subsystems.Elevator.Direction;

/**
 * Add your docs here.
 */
public class OI {
    private static OI oi = null;

    private final int LEFT_STICK = 0,
        RIGHT_STICK = 1,
        BUTTON_BOX = 2;

    public final AttackThree leftStick, rightStick;
    // public final ButtonBox buttonBox;

    private OI() {
        leftStick = new AttackThree(LEFT_STICK);
        rightStick = new AttackThree(RIGHT_STICK);
        // buttonBox = new ButtonBox(BUTTON_BOX);

        // // map button box commands
        // // elevator
        // buttonBox.upperRocketCargo.whenPressed(new ElevateToHeight(Elevator.Position.RocketHatchThree));
        // buttonBox.middleRocketCargo.whenPressed(new ElevateToHeight(Elevator.Position.RocketCargoTwo));
        // buttonBox.lowRocketCargo.whenPressed(new ElevateToHeight(Elevator.Position.RocketCargoTwo));

        // buttonBox.upperRocketPanel.whenPressed(new ElevateToHeight(Elevator.Position.RocketHatchThree));
        // buttonBox.middleRocketPanel.whenPressed(new ElevateToHeight(Elevator.Position.RocketCargoTwo));
        // buttonBox.lowRocketPanel.whenPressed(new ElevateToHeight(Elevator.Position.HatchOne));

        // buttonBox.cargoShipCargo.whenPressed(new ElevateToHeight(Elevator.Position.CargoShipCargo));
        // buttonBox.cargoShipPanel.whenPressed(new ElevateToHeight(Elevator.Position.HatchOne));

        // // collector
        // buttonBox.intakeCargo.whenPressed(new AutoCargoCollect());
        // buttonBox.intakePanel.whenPressed(new ElevateToHeight(Elevator.Position.HatchOne));
        // buttonBox.extakeCargo.whenPressed(new RollIntakeForCargo(Collector.Speed.IN));
        // buttonBox.extakePanel.whenPressed(new ExtakeHatchPanel());

        // // Climber
        // buttonBox.cLimb.whenPressed(new Climb());

        // // Manual
        // buttonBox.manualElevator.getForward().whenPressed(new ElevateManual(Direction.UP));
        // buttonBox.manualElevator.getForward().whenPressed(new ElevateManual(Direction.DOWN));
        // buttonBox.manualCollector.getForward().whenPressed(new OpenCollector());
        // buttonBox.manualCollector.getBackward().whenPressed(new CloseCollector());
        // buttonBox.manualRoller.getForward().whenPressed(new RollIntakeForCargo(Speed.OUT));
        // buttonBox.manualRoller.getBackward().whenPressed(new RollIntakeForCargo(Speed.IN));
        // buttonBox.firePiston.whenPressed(new ExtakeHatchPanel());
        // buttonBox.manualClimber.getForward().whileHeld(new RollManual(Climber.Direction.FORWARD));  
        // buttonBox.manualClimber.getBackward().whileHeld(new RollManual(Climber.Direction.BACKWARD));
    }

    /**
     * Gets the  Drivetrain instance
     * @return the single instance of the class
     */
    public static OI getInstance() {
        if (oi == null)
            oi = new OI();
        return oi;
    }
}
