// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.k_shooter;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.grabber;
import frc.robot.subsystems.loader;
import frc.robot.subsystems.shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class autoCommand extends SequentialCommandGroup {
  private final drive m_drive;
  private final grabber m_grabber;
  private final loader m_loader;
  private final shooter m_shooter;

  /** Creates a new autoCommand. */
  public autoCommand(drive drive, grabber grabber, loader loader, shooter shooter) {
    m_drive = drive;
    m_grabber = grabber;
    m_loader = loader;
    m_shooter = shooter;

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    //addCommands(new driveStraight(0.2, 1, m_drive));
    addCommands(new autoRunShooter(1.0, k_shooter.frontShooterSpeedRPM, k_shooter.backShooterSpeedRPM, m_shooter));
    addCommands(new autoRunLoader(2.0, m_loader));
    addCommands(new ParallelCommandGroup(
      new autoRunShooter(0.5, k_shooter.frontIdleSpeedRPM, k_shooter.backIdleSpeedRPM, m_shooter),
      new autoRunGrabber(m_grabber)));
    addCommands(new driveStraight(-0.5, 4, m_drive));

  }
}
