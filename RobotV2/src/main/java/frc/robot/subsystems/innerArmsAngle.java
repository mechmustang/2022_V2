// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.k_innerArms;


public class innerArmsAngle extends SubsystemBase {
  private final CANSparkMax m_angleMotor;
  private final SparkMaxPIDController m_anglePID;
  private final RelativeEncoder m_angleEncoder;

  /** Creates a new innerArms. */
  public innerArmsAngle() {
    
    m_angleMotor = new CANSparkMax(k_innerArms.angleCanID, MotorType.kBrushless);
    m_angleMotor.setInverted(k_innerArms.aMotorReversed);
    m_anglePID = m_angleMotor.getPIDController();
    m_angleEncoder = m_angleMotor.getEncoder();

    m_anglePID.setP(k_innerArms.akP);
    m_anglePID.setI(k_innerArms.akI);
    m_anglePID.setD(k_innerArms.akD);
    m_anglePID.setIZone(k_innerArms.akIz);
    m_anglePID.setFF(k_innerArms.akFF);
    m_anglePID.setOutputRange(k_innerArms.akMinOutput, k_innerArms.akMaxOutput);

  }

  public void homeArms() {
    m_anglePID.setReference(0, CANSparkMax.ControlType.kPosition);
  }

  public void setAngle(double angle) {
    // do some math to calibrate angle into a position
    double position = angle;
    m_anglePID.setReference(position, CANSparkMax.ControlType.kPosition);
  }

  public double getAngle() {
    return m_angleEncoder.getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

