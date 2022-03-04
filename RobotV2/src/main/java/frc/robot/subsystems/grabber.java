// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class grabber extends SubsystemBase {
  private final VictorSPX m_grabber;

  /** Creates a new shooter. */
  public grabber() {
    m_grabber = new VictorSPX(k_shooter.graberCanID);
  }

  public void startGrabber() {
    m_grabber.set(ControlMode.PercentOutput, k_shooter.grabberSpeed);
  }

  public void stopGrabber() {
    m_grabber.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
