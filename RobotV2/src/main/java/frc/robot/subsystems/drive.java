// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class drive extends SubsystemBase {
  /** Creates a new chassis. */
  TalonSRX leftLeader;
  TalonSRX rightLeader;
  TalonSRX leftFollower;
  TalonSRX rightFollower;

  DifferentialDrive drive;

  public drive() {
    leftLeader = new TalonSRX(k_chassis.leftLeadCanID);
    rightLeader = new TalonSRX(k_chassis.rightLeadCanID);
    leftFollower = new TalonSRX(k_chassis.leftFollowerCanID);
    rightFollower = new TalonSRX(k_chassis.rightFollowerCanID);

    MotorControllerGroup leftMotors = new MotorControllerGroup(leftLeader, leftFollower);
    MotorControllerGroup rightMotors = new MotorControllerGroup(rightLeader, rightFollower);

    drive = new DifferentialDrive(leftMotors, rightMotors);

    leftMotors.setInverted(k_chassis.leftMotorsInverted);
    rightMotors.setInverted(k_chassis.rightMotorsInverted);

    leftMotors.stopMotor();
    rightMotors.stopMotor();

  }

  public void arcadeDrive(double speed, double rot) {
    drive.arcadeDrive(speed, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
