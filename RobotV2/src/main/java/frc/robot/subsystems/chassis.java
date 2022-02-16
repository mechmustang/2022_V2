// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class chassis extends SubsystemBase {
  /** Creates a new chassis. */
  TalonSRX leftLeader;
  TalonSRX rightLeader;
  TalonSRX leftFollower;
  TalonSRX rightFollower;

  public chassis() {
    leftLeader = new TalonSRX(0);
    rightLeader = new TalonSRX(1);
    leftFollower = new TalonSRX(2);
    rightFollower = new TalonSRX(3);

    leftFollower.set(ControlMode.PercentOutput, 0);
    leftLeader.set(ControlMode.PercentOutput, 0);
    rightFollower.set(ControlMode.PercentOutput, 0);
    rightLeader.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
