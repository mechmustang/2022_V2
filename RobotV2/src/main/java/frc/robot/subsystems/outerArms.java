// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.k_outerArms;


public class outerArms extends SubsystemBase {
  private CANSparkMax m_angleMotor, m_lengthMotor;
  private SparkMaxPIDController m_lengthPID, m_anglePID;
  public RelativeEncoder m_lengthEncoder, m_angleEncoder;

  /** Creates a new innerArms. */
  public outerArms() {
    
    m_lengthMotor = new CANSparkMax(k_outerArms.lengthCanID, MotorType.kBrushless);
    m_angleMotor = new CANSparkMax(k_outerArms.angleCanID, MotorType.kBrushless);

    m_lengthMotor.setInverted(k_outerArms.lMotorReversed);
    m_angleMotor.setInverted(k_outerArms.aMotorReversed);

    m_lengthPID = m_lengthMotor.getPIDController();
    m_anglePID = m_angleMotor.getPIDController();

    m_lengthEncoder = m_lengthMotor.getEncoder();
    m_angleEncoder = m_angleMotor.getEncoder();

    m_lengthPID.setI(k_outerArms.lkI);
    m_lengthPID.setD(k_outerArms.lkD);
    m_lengthPID.setIZone(k_outerArms.lkIz);
    m_lengthPID.setFF(k_outerArms.lkFF);
    m_lengthPID.setOutputRange(k_outerArms.lkMinOutput, k_outerArms.lkMaxOutput);
    m_lengthPID.setP(k_outerArms.lkP);

    m_anglePID.setP(k_outerArms.akP);
    m_anglePID.setI(k_outerArms.akI);
    m_anglePID.setD(k_outerArms.akD);
    m_anglePID.setIZone(k_outerArms.akIz);
    m_anglePID.setFF(k_outerArms.akFF);
    m_anglePID.setOutputRange(k_outerArms.akMinOutput, k_outerArms.akMaxOutput);

  }

  public void haltArms() {
    m_lengthMotor.set(0);
    m_angleMotor.set(0);
  }

  public void homeArms() {
    m_lengthPID.setReference(0, CANSparkMax.ControlType.kPosition);
    m_anglePID.setReference(0, CANSparkMax.ControlType.kPosition);
  }

  public void setAngle(double angle) {
    // do some math to calibrate angle into a position
    double position = angle;
    m_anglePID.setReference(position, CANSparkMax.ControlType.kPosition);
  }

  public void setLength(double length) {
    // do some math to calibrate length into a postion
    double position = length;
    m_lengthPID.setReference(position, CANSparkMax.ControlType.kPosition);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
