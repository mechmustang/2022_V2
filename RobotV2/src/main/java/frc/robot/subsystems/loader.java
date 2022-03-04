// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class loader extends SubsystemBase {
  
  private final VictorSPX m_loader;

  /** Creates a new loader. */
  public loader() {
    m_loader = new VictorSPX(k_shooter.loaderCanID);
  }

  public void startLoader() {
    m_loader.set(ControlMode.PercentOutput, k_shooter.loaderSpeed);
  }

  public void stopLoader() {
    m_loader.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
