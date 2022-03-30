// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.loader;

public class autoRunLoader extends CommandBase {
  private double m_time = 0.0;
  private double startTime;
  private final loader m_loader;
  /** Creates a new autoRunLoader. */
  public autoRunLoader(double time, loader loader) {
    m_time = time*1000;
    m_loader = loader;
    addRequirements(m_loader);
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
    m_loader.startLoader();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_loader.stopLoader();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_time <= System.currentTimeMillis() - startTime);
  }
}
