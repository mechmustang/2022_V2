// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class arm extends SubsystemBase {
  /** Creates a new arm. */
  public int CanIDLength;
  public int CanIDAngle;

  public SparkMAX lengthMotor;
  public SparkMAX angleMotor;

  public arm(int CanIDLength, int CanIDAngle) {
    this.CanIDLength = CanIDLength;
    this.CanIDAngle = CanIDAngle;

    lengthMotor = new SparkMAX(this.CanIDLength);
    angleMotor = new SparkMAX(this.CanIDAngle);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
