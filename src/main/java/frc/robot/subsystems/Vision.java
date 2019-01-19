/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Reads values from NetworkTables written from the Pi
 */
public class Vision {
    private static Vision vision;

    private NetworkTable table;
    String tableKey = "ProcessedTape";

    private Vision() {
        table = NetworkTableInstance.getDefault().getTable(tableKey);
    }

    /**
     * Gets the Vision instance
     * @return the single instance of the class
     */
    public static Vision getInstance() {
        if (vision == null)
            vision = new Vision();
        return vision;
    }

    /**
     * Gets the array of x coordinates of cargo ports detected by the rPi
     * @return array of x coordinates of detected cargo ports
     */
    public double[] getXCoordinates() {
        return table.getEntry("x_coordinates").getDoubleArray(new double[0]);
    }
}
