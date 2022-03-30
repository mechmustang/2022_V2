// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter;

public class autoRunShooter extends CommandBase {
  /** Creates a new autoRunShooter. */
  private double m_time;
  private double m_backspeed;
  private double m_frontspeed;
  private shooter m_shooter;
  private double startTime;

  public autoRunShooter(double time, double frontspeed, double backspeed, shooter shooter) {
    m_time = time*1000;
    m_frontspeed = frontspeed;
    m_backspeed = backspeed;
    m_shooter = shooter;
    addRequirements(m_shooter);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.run(m_frontspeed, m_backspeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_time <= System.currentTimeMillis() - startTime);
  }
}
