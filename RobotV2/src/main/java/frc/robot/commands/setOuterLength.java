// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.outerArmsLength;

public class setOuterLength extends CommandBase {
  private final outerArmsLength m_outerArmsLength;
  private double m_length;

  /** Creates a new setOuterLength. */
  public setOuterLength(outerArmsLength outerArmsLength, double length) {
    m_outerArmsLength = outerArmsLength;
    m_length = length;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_outerArmsLength);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_outerArmsLength.setLength(m_length);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_outerArmsLength.halt();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println(m_length);
    System.out.println(m_outerArmsLength.getLength());
    return (m_length >= m_outerArmsLength.getLength()-1 && m_length <= m_outerArmsLength.getLength()+1);
  }
}
