// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveIds{
    public static final int FL_ID = 1;
    public static final int FR_ID = 2;
    public static final int RL_ID = 3;
    public static final int RR_ID = 4;
  }
  public static final class IntakeIds{
    public static final int Grab1_ID = 5;
    public static final int Grab2_ID = 6;
    public static final int Lift_ID = 7;
  }
  public static final class ShooterIds{
    public static final int BottemShooter_ID = 8;
    public static final int TopShooter_ID = 9;
  }
}
