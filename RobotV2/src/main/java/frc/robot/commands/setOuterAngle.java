// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.outerArmsAngle;

public class setOuterAngle extends CommandBase {
  private final outerArmsAngle m_outerArmsAngle;
  private double m_position;

  /** Creates a new setOuterAngle. */
  public setOuterAngle(outerArmsAngle outerArmsAngle, double position) {
    m_outerArmsAngle = outerArmsAngle;
    m_position = position;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_outerArmsAngle);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_outerArmsAngle.setAngle(m_position);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_position == m_outerArmsAngle.getAngle();
  }
}
