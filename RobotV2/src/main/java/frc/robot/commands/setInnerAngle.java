// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.innerArmsAngle;

public class setInnerAngle extends CommandBase {
  private final innerArmsAngle m_innerArmAngle;
  private double m_position;

  /** Creates a new setInnerAngle. */
  public setInnerAngle(innerArmsAngle innerArmsAngle, double position) {
    m_innerArmAngle = innerArmsAngle;
    m_position = position;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_innerArmAngle);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_innerArmAngle.setAngle(m_position);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
