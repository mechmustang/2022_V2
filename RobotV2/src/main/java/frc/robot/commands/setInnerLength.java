// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.innerArmsLength;

public class setInnerLength extends CommandBase {
  private final innerArmsLength m_innerArmsLength;
  private double m_length;

  /** Creates a new setInnerLength. */
  public setInnerLength(innerArmsLength innerArmsLength, double length) {
    m_innerArmsLength = innerArmsLength;
    m_length = length;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_innerArmsLength);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_innerArmsLength.setLength(m_length);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_innerArmsLength.halt();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_length >= m_innerArmsLength.getLength()-1 && m_length <= m_innerArmsLength.getLength()+1);
  }
}
