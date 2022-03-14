// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.innerArmsAngle;
import frc.robot.subsystems.innerArmsLength;
import frc.robot.subsystems.outerArmsAngle;
import frc.robot.subsystems.outerArmsLength;

public class testArms extends SequentialCommandGroup {
  private final innerArmsAngle m_innerArmsAngle;
  private final innerArmsLength m_innerArmsLength;
  private final outerArmsAngle m_outerArmsAngle;
  private final outerArmsLength m_outerArmsLength;

  /** Creates a new testArms. */
  public testArms(innerArmsAngle innerArmsAngle, 
    innerArmsLength innerArmsLength,
    outerArmsAngle outerArmsAngle,
    outerArmsLength outerArmsLength) {

    m_innerArmsAngle = innerArmsAngle;
    m_innerArmsLength = innerArmsLength;
    m_outerArmsAngle = outerArmsAngle;
    m_outerArmsLength = outerArmsLength;

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    //addCommands(new setInnerAngle(m_innerArmsAngle, 10));
    //addCommands(new setOuterAngle(m_outerArmsAngle, 5));
    addCommands(new ParallelCommandGroup(           // reach up and slightly out with the inner arms
      new setInnerLength(m_innerArmsLength, 150),   
      new setInnerAngle(m_innerArmsAngle, 5)));
    addCommands(new setInnerAngle(m_innerArmsAngle, -5)); // move inner arms back to hook bar
    addCommands(new ParallelCommandGroup(           // lift robot with inner and angle outer forward
      new setInnerLength(m_innerArmsLength, 0),
      new setOuterAngle(m_outerArmsAngle, 20)));
    addCommands(new setOuterLength(m_outerArmsLength, 150));  // extend outer arms
  }
}
