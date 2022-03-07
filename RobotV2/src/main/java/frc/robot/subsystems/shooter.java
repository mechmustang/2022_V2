// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooter extends SubsystemBase {
  private final CANSparkMax m_shooterFront;
  private final CANSparkMax m_shooterBack;
  private final SparkMaxPIDController m_frontPID;
  private final SparkMaxPIDController m_backPID;
  private final RelativeEncoder m_frontEncoder;
  private final RelativeEncoder m_backEncoder;


  /** Creates a new shooter. */
  public shooter() {

    m_shooterFront = new CANSparkMax(k_shooter.shooterFrontCanID, MotorType.kBrushless);
    m_shooterBack = new CANSparkMax(k_shooter.shooterBackCanID, MotorType.kBrushless);

    m_shooterFront.setInverted(k_shooter.frontMotorInverted);
    m_shooterBack.setInverted(k_shooter.backMotorInverted);
  
    m_frontPID = m_shooterFront.getPIDController();
    m_backPID = m_shooterBack.getPIDController();

    m_frontEncoder = m_shooterFront.getEncoder();
    m_backEncoder = m_shooterBack.getEncoder();
    
    m_frontPID.setP(k_shooter.kPfront);
    m_frontPID.setI(k_shooter.kIfront);
    m_frontPID.setD(k_shooter.kDfront);
    m_frontPID.setIZone(k_shooter.kIzfront);
    m_frontPID.setFF(k_shooter.kFFfront);
    m_frontPID.setOutputRange(k_shooter.kMinOutputFront, k_shooter.kMaxOutputFront);

    m_backPID.setP(k_shooter.kPback);
    m_backPID.setI(k_shooter.kIback);
    m_backPID.setD(k_shooter.kDback);
    m_backPID.setIZone(k_shooter.kIzback);
    m_backPID.setFF(k_shooter.kFFback);
    m_backPID.setOutputRange(k_shooter.kMinOutputBack, k_shooter.kMaxOutputBack);

  }

  public void startShooter() {
    m_frontPID.setReference(k_shooter.frontShooterSpeedRPM, ControlType.kSmartVelocity);
    m_backPID.setReference(k_shooter.backShooterSpeedRPM, ControlType.kSmartVelocity);

  }

  public void idle() {
    m_frontPID.setReference(k_shooter.frontIdleSpeedRPM, ControlType.kSmartVelocity);
    m_backPID.setReference(k_shooter.backIdleSpeedRPM, ControlType.kSmartVelocity);
  }

  public void stopShooter() {
    m_frontPID.setReference(0, ControlType.kSmartVelocity);
    m_backPID.setReference(0, ControlType.kSmartVelocity);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
