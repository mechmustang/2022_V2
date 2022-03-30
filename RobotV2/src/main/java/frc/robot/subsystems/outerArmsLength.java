// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.k_outerArms;


public class outerArmsLength extends SubsystemBase {
  private final CANSparkMax m_lengthMotor;
  private final SparkMaxPIDController m_lengthPID;
  private final RelativeEncoder m_lengthEncoder;

  /** Creates a new innerArms. */
  public outerArmsLength() {
    
    m_lengthMotor = new CANSparkMax(k_outerArms.lengthCanID, MotorType.kBrushless);
    m_lengthMotor.setInverted(k_outerArms.lMotorReversed);
    m_lengthMotor.setSmartCurrentLimit(30, 20, 0);
    m_lengthPID = m_lengthMotor.getPIDController();
    m_lengthEncoder = m_lengthMotor.getEncoder();

    m_lengthPID.setI(k_outerArms.lkI);
    m_lengthPID.setD(k_outerArms.lkD);
    m_lengthPID.setIZone(k_outerArms.lkIz);
    m_lengthPID.setFF(k_outerArms.lkFF);
    m_lengthPID.setOutputRange(k_outerArms.lkMinOutput, k_outerArms.lkMaxOutput);
    m_lengthPID.setP(k_outerArms.lkP);
    m_lengthPID.setSmartMotionMaxVelocity(8000, 0);
    m_lengthPID.setSmartMotionMaxAccel(2000, 0);

    m_lengthMotor.burnFlash();
  }

  public void homeArms() {
    m_lengthPID.setReference(0, CANSparkMax.ControlType.kSmartMotion);
  }

  public void setLength(double length) {
    // do some math to calibrate length into a postion
    double position = length;
    m_lengthPID.setReference(position, CANSparkMax.ControlType.kSmartMotion);
  }

  public double getLength() {
    return m_lengthEncoder.getPosition();
  }

  public void move(double speed) {
    m_lengthMotor.set(speed);
    SmartDashboard.putNumber("Outer Length", m_lengthEncoder.getPosition());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
