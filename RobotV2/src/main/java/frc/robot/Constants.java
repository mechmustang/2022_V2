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
   
   public final class k_chassis {
      public static final int leftLeadCanID = 1;
      public static final int rightLeadCanID = 2;
      public static final int leftFollowerCanID = 3;
      public static final int rightFollowerCanID = 4;

      public static final boolean leftMotorsInverted = false;
      public static final boolean rightMotorsInverted = false;

      public static final int kDriveControlStick = 0;
   }

   public final class shooter {
      public static final int graberCanID = 5;
      public static final int loaderCanID = 6;
      public static final int shooterCanID = 7;
   }

   public final class innerArms {
      public static final int lengthCanID = 8; //SparkMAX motor controller
      public static final int angleCanID = 9;  //SparkMAX motor controller
      public static final double akP = 0.1; 
      public static final double akI = 1e-4;
      public static final double akD = 1;
      public static final double akIz = 0;
      public static final double akFF = 0;
      public static final double akMaxOutput = 1; 
      public static final double akMinOutput = -1;
      public static final double lkP = 0.1; 
      public static final double lkI = 1e-4;
      public static final double lkD = 1;
      public static final double lkIz = 0;
      public static final double lkFF = 0;
      public static final double lkMaxOutput = 1; 
      public static final double lkMinOutput = -1;

      public static final boolean lEncoderReversed = false;
      public static final boolean lMotorReversed = false;
      public static final boolean aEncoderReversed = false;
      public static final boolean aMotorReversed = false;
   }

   public final class outerArms {
      public static final int lengthCanID = 10;
      public static final int angleCanID = 11;
      public static final double akP = 0.1; 
      public static final double akI = 1e-4;
      public static final double akD = 1;
      public static final double akIz = 0;
      public static final double akFF = 0;
      public static final double akMaxOutput = 1; 
      public static final double akMinOutput = -1;
      public static final double lkP = 0.1; 
      public static final double lkI = 1e-4;
      public static final double lkD = 1;
      public static final double lkIz = 0;
      public static final double lkFF = 0;
      public static final double lkMaxOutput = 1; 
      public static final double lkMinOutput = -1;
      
      public static final boolean lEncoderReversed = false;
      public static final boolean lMotorReversed = false;
      public static final boolean aEncoderReversed = false;
      public static final boolean aMotorReversed = false;
   }
}
