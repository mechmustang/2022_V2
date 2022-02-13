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
   
   public final class chassis {
      public final int leftLeadCanID = 1;
      public final int rightLeadCanID = 2;
      public final int leftFollowerCanID = 3;
      public final int rightFollowerCanID = 4;

   }

   public final class shooter {
      public final int graberCanID = 5;
      public final int loaderCanID = 6;
      public final int shooterCanID = 7;

   }

   public final class innerArms {
      public final int lengthCanID = 8;
      public final int angleCanID = 9;

   }

   public final class outerArms {
      public final int lengthCanID = 10;
      public final int angleCanID = 11;

   }
}
