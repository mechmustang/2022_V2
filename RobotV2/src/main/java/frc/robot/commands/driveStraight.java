// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive;

public class driveStraight extends CommandBase {
  /** Creates a new driveStraight. */
  private drive m_drive;
  private double m_speed = 0.0, m_time = 0.0;
  private double startTime;

  public driveStraight(double speed, double time, drive drive) {
    m_drive = drive;
    m_speed = speed;
    m_time = time * 1000;

    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, 0);
    startTime = System.currentTimeMillis();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(m_speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.halt();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_time <= System.currentTimeMillis() - startTime);
    //return false;
  }
}
