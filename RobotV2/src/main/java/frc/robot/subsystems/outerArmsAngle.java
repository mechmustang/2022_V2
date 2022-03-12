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


public class outerArmsAngle extends SubsystemBase {
  private final CANSparkMax m_angleMotor;
  private final SparkMaxPIDController m_anglePID;
  private final RelativeEncoder m_angleEncoder;

  /** Creates a new innerArms. */
  public outerArmsAngle() {
    
    m_angleMotor = new CANSparkMax(k_outerArms.angleCanID, MotorType.kBrushless);
    m_angleMotor.setInverted(k_outerArms.aMotorReversed);
    m_anglePID = m_angleMotor.getPIDController();
    m_angleEncoder = m_angleMotor.getEncoder();

    m_anglePID.setP(k_outerArms.akP);
    m_anglePID.setI(k_outerArms.akI);
    m_anglePID.setD(k_outerArms.akD);
    m_anglePID.setIZone(k_outerArms.akIz);
    m_anglePID.setFF(k_outerArms.akFF);
    m_anglePID.setOutputRange(k_outerArms.akMinOutput, k_outerArms.akMaxOutput);

  }

  public void homeArms() {
    m_anglePID.setReference(0, CANSparkMax.ControlType.kSmartMotion);
  }

  public void setAngle(double angle) {
    // do some math to calibrate angle into a position
    double position = angle;
    m_anglePID.setReference(position, CANSparkMax.ControlType.kSmartMotion);
  }

  public double getAngle() {
    return m_angleEncoder.getPosition();
  }

  public void move(double speed) {
    m_angleMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
