// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive;

public class driveDistance extends CommandBase {
  /** Creates a new driveDistance. */
  public double m_distance;
  public final drive m_chassis = new drive();

  public driveDistance(double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_distance = distance;
    addRequirements(m_chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_chassis.halt();
    m_chassis.resetEncoders();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_chassis.driveStraight(0.6);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_chassis.halt();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_chassis.getDistance() >= m_distance);
  }
}
