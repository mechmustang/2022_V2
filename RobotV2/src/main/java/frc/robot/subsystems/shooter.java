// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooter extends SubsystemBase {
  private final CANSparkMax m_shooterBack;
  private final SparkMaxPIDController m_backPID;
  private final RelativeEncoder m_backEncoder;
  
  private final CANSparkMax m_shooterFront;
  private final SparkMaxPIDController m_frontPID;
  private final RelativeEncoder m_frontEncoder;
  
  private double m_frontSetPoint;
  private double m_backSetPoint;


  /** Creates a new shooter. */
  public shooter() {

    m_shooterBack = new CANSparkMax(k_shooter.shooterBackCanID, MotorType.kBrushless);
    m_shooterBack.setInverted(k_shooter.backMotorInverted);
    m_backPID = m_shooterBack.getPIDController();
    m_backEncoder = m_shooterBack.getEncoder();

    m_backPID.setP(k_shooter.kPback);
    m_backPID.setI(k_shooter.kIback);
    m_backPID.setD(k_shooter.kDback);
    m_backPID.setIZone(k_shooter.kIzback);
    m_backPID.setFF(k_shooter.kFFback);
    m_backPID.setOutputRange(k_shooter.kMinOutputBack, k_shooter.kMaxOutputBack);

    m_shooterFront = new CANSparkMax(k_shooter.shooterFrontCanID, MotorType.kBrushless);
    m_shooterFront.setInverted(k_shooter.frontMotorInverted);
    m_frontPID = m_shooterFront.getPIDController();
    m_frontEncoder = m_shooterFront.getEncoder();
    
    m_frontPID.setP(k_shooter.kPfront);
    m_frontPID.setI(k_shooter.kIfront);
    m_frontPID.setD(k_shooter.kDfront);
    m_frontPID.setIZone(k_shooter.kIzfront);
    m_frontPID.setFF(k_shooter.kFFfront);
    m_frontPID.setOutputRange(k_shooter.kMinOutputFront, k_shooter.kMaxOutputFront);
  }

  public void run(double frontSetpoint, double backSetpoint) {
    m_frontSetPoint = frontSetpoint;
    m_backSetPoint = backSetpoint;
    m_backPID.setReference(m_backSetPoint, CANSparkMax.ControlType.kSmartVelocity);
    m_frontPID.setReference(m_frontSetPoint, CANSparkMax.ControlType.kSmartVelocity);

  }

  public void idle() {
    m_backPID.setReference(k_shooter.backIdleSpeedRPM, CANSparkMax.ControlType.kSmartVelocity);
  }

  public void stop() {
    m_backPID.setReference(0, CANSparkMax.ControlType.kSmartVelocity);
  }

  public void close() {
    m_shooterBack.close();
  }

  public double getFrontSpeed() {
    return m_frontEncoder.getVelocity();
  }

  public double getBackSpeed() {
    return m_backEncoder.getVelocity();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}