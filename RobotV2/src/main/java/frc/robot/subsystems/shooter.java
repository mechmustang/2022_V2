// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooter extends SubsystemBase {
  public final WPI_TalonSRX grabber;
  public final WPI_TalonSRX loader;
  public final CANSparkMax shooterFront;
  public final CANSparkMax shooterBack;
  public final SparkMaxPIDController frontPID;
  public final SparkMaxPIDController backPID;
  public final RelativeEncoder frontEncoder;
  public final RelativeEncoder backEncoder;


  /** Creates a new shooter. */
  public shooter() {
    grabber = new WPI_TalonSRX(k_shooter.graberCanID);
    loader = new WPI_TalonSRX(k_shooter.loaderCanID);
    shooterFront = new CANSparkMax(k_shooter.shooterFrontCanID, MotorType.kBrushless);
    shooterBack = new CANSparkMax(k_shooter.shooterBackCanID,MotorType.kBrushless);

    shooterFront.setInverted(k_shooter.frontMotorInverted);
    shooterBack.setInverted(k_shooter.backMotorInverted);
  
    frontPID = shooterFront.getPIDController();
    backPID = shooterBack.getPIDController();

    frontEncoder = shooterFront.getEncoder();
    backEncoder = shooterBack.getEncoder();

    frontEncoder.setInverted(k_shooter.frontEncoderInverted);
    backEncoder.setInverted(k_shooter.backEncoderInverted);
    
    frontPID.setP(k_shooter.kPfront);
    frontPID.setI(k_shooter.kIfront);
    frontPID.setD(k_shooter.kDfront);
    frontPID.setIZone(k_shooter.kIzfront);
    frontPID.setFF(k_shooter.kFFfront);
    frontPID.setOutputRange(k_shooter.kMinOutputFront, k_shooter.kMaxOutputFront);

    backPID.setP(k_shooter.kPback);
    backPID.setI(k_shooter.kIback);
    backPID.setD(k_shooter.kDback);
    backPID.setIZone(k_shooter.kIzback);
    backPID.setFF(k_shooter.kFFback);
    backPID.setOutputRange(k_shooter.kMinOutputBack, k_shooter.kMaxOutputBack);

  }

  public void startGrabber() {
    grabber.setVoltage(k_shooter.grabberSpeed);
  }

  public void startLoader() {
    loader.setVoltage(k_shooter.loaderSpeed);
  }

  public void startShooter() {
    frontPID.setReference(k_shooter.shooterSpeed, ControlType.kSmartVelocity);
    backPID.setReference(k_shooter.shooterSpeed, ControlType.kSmartVelocity);

  }

  public void stopGrabber() {
    grabber.setVoltage(0);
  }

  public void stopLoader() {
    loader.setVoltage(0);
  }

  public void stopShooter() {
    frontPID.setReference(0, ControlType.kSmartVelocity);
    backPID.setReference(0, ControlType.kSmartVelocity);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
