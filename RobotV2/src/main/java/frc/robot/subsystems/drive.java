// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import frc.robot.Robot;
//import edu.wpi.first.wpilibj.AnalogGyro;
//import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.Encoder;
//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.ctre.phoenix.motorcontrol.Faults;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

// **** Something needs to happen with motor safety ****

public class drive extends SubsystemBase {
  /** Creates a new chassis. */
  private final WPI_TalonSRX leftLeader;
  private final WPI_TalonSRX rightLeader;
  private final WPI_TalonSRX leftFollower;
  private final WPI_TalonSRX rightFollower;

  private final DifferentialDrive drive; 

  //public final Encoder leftEncoder;
  //public final Encoder rightEncoder;

  //public final AnalogGyro gyroscope = new AnalogGyro();

  public drive() {
    leftLeader = new WPI_TalonSRX(k_chassis.leftLeadCanID);
    rightLeader = new WPI_TalonSRX(k_chassis.rightLeadCanID);
    leftFollower = new WPI_TalonSRX(k_chassis.leftFollowerCanID);
    rightFollower = new WPI_TalonSRX(k_chassis.rightFollowerCanID);

    drive = new DifferentialDrive(leftLeader, rightLeader); 

    //leftEncoder = new Encoder(0, 1);
    //rightEncoder = new Encoder(2, 3);

    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);

    leftLeader.setInverted(k_chassis.leftMotorsInverted);
    rightLeader.setInverted(k_chassis.rightMotorsInverted);
    leftFollower.setInverted(InvertType.FollowMaster);
    rightFollower.setInverted(InvertType.FollowMaster);

    //leftEncoder.setReverseDirection(k_chassis.leftEncoderInverted);
    //rightEncoder.setReverseDirection(k_chassis.rightEncoderInverted);

    //leftEncoder.setDistancePerPulse(6 * Math.PI / 1440);
    //rightEncoder.setDistancePerPulse(6 * Math.PI / 1440);

  }

  public void arcadeDrive(double speed, double rot) {
    drive.arcadeDrive(-speed*0.8, 0.7*rot);

  }

  public void preciseDrive(double moving, double turning) {
    double speed = 0;
    double turn = 0;

    if (moving >= -0.02 || moving <= 0.02) {
      turn = k_chassis.rotationMultiplier * turning;
    } else if (moving >= -0.30 || moving <= 0.30) {
      speed = k_chassis.speedMultiplier * moving * 0.5;
      if (Math.abs(turning) > .10) {
        turn = k_chassis.rotationMultiplier * turning * 0.9; 
      }
    } else {
      turn = k_chassis.rotationMultiplier * turning;
      speed = moving * k_chassis.speedMultiplier;
    }

     drive.arcadeDrive(speed, turn);

  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  // Drive straight will use the encoders (or possibly just the gyro) to drive without veering
  public void driveStraight(double speed) {
    double correction = 0;   //add code here to read gyro and correct for heading change
    drive.tankDrive(speed, speed + correction);

  }

  public void halt() {
    drive.arcadeDrive(0, 0);

  }

  public void setMaxOutput(double maxSpeed) {
    drive.setMaxOutput(maxSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
