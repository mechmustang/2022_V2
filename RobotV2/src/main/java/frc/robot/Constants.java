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

      public static final boolean leftEncoderInverted = false;
      public static final boolean rightEncoderInverted = false;

      public static final int kDriveControlStick = 0;
      public static final int kSystemController = 1;
   }

   public final class k_shooter {
      public static final int graberCanID = 5;        //Talon SRX
      public static final int loaderCanID = 6;        //Talon SRX
      public static final int shooterFrontCanID = 7;  //Spark MAX
      public static final int shooterBackCanID = 12;  //Spark MAX

      public static final boolean frontMotorInverted = false;
      public static final boolean backMotorInverted = false;
      public static final boolean backEncoderInverted = false;
      public static final boolean frontEncoderInverted = false;
      
      public static final double kPfront = 0.0001;
      public static final double kIfront = 0;
      public static final double kDfront = 0.00001;
      public static final double kIzfront = 0;
      public static final double kFFfront = 0.0002;
      public static final double kMinOutputFront = -1;
      public static final double kMaxOutputFront = 1;
      
      public static final double kPback = 0.0001;
      public static final double kIback = 0;
      public static final double kDback = 0.00001;
      public static final double kIzback = 0;
      public static final double kFFback = 0.00002;
      public static final double kMinOutputBack = -1;
      public static final double kMaxOutputBack = 1;

      public static final double grabberSpeed = 0.5;   //Talon SRX voltage as a percentage
      public static final double loaderSpeed = 0.5;    //Talon SRX voltage as a percentage
      public static final double shooterSpeed = 1000;  //Spark MAX speed in RPM
   
   }

   public final class innerArms {
      public static final int lengthCanID = 8; //SparkMAX motor controller
      public static final int angleCanID = 9;  //SparkMAX motor controller
      public static final double akP = 0.0001; 
      public static final double akI = 0;
      public static final double akD = 0.000001;
      public static final double akIz = 0;
      public static final double akFF = 0.00002;
      public static final double akMaxOutput = 1; 
      public static final double akMinOutput = -1;
      public static final double lkP = 0.0001; 
      public static final double lkI = 0;
      public static final double lkD = 0.000001;
      public static final double lkIz = 0;
      public static final double lkFF = 0.00002;
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
      public static final double akP = 0.0001; 
      public static final double akI = 0;
      public static final double akD = 0.000001;
      public static final double akIz = 0;
      public static final double akFF = 0.00002;
      public static final double akMaxOutput = 1; 
      public static final double akMinOutput = -1;
      public static final double lkP = 0.0001; 
      public static final double lkI = 0;
      public static final double lkD = 0.000001;
      public static final double lkIz = 0;
      public static final double lkFF = 0.0001;
      public static final double lkMaxOutput = 1; 
      public static final double lkMinOutput = -1;
      
      public static final boolean lEncoderReversed = false;
      public static final boolean lMotorReversed = false;
      public static final boolean aEncoderReversed = false;
      public static final boolean aMotorReversed = false;
   }
}
