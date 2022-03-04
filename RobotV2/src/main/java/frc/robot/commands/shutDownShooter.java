// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter;
import frc.robot.subsystems.loader;
import frc.robot.subsystems.grabber;

public class shutDownShooter extends CommandBase {
  /** Creates a new shutDownShooter. */
  shooter m_shooter = new shooter();
  loader m_loader = new loader();
  grabber m_grabber = new grabber();

  public shutDownShooter() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_loader);
    addRequirements(m_shooter);
    addRequirements(m_grabber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_grabber.stopGrabber();
    m_loader.stopLoader();
    m_shooter.stopShooter();
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
