// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter;

public class runShooter extends CommandBase {
  private final shooter m_shooter;
  private double m_frontSetPoint;
  private double m_backSetPoint;

  /** Creates a new runShooter. */
  public runShooter(shooter shooter, double frontSetPoint, double backSetPoint) {
    m_frontSetPoint = frontSetPoint;
    m_backSetPoint = backSetPoint;
    m_shooter = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.run(m_frontSetPoint, m_backSetPoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //m_shooterBack.run(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
