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

public class newArms extends SequentialCommandGroup {
  private final innerArmsAngle m_innerArmsAngle;
  private final innerArmsLength m_innerArmsLength;
  private final outerArmsAngle m_outerArmsAngle;
  private final outerArmsLength m_outerArmsLength;

  /** Creates a new testArms. */
  public newArms(innerArmsAngle innerArmsAngle, 
    innerArmsLength innerArmsLength,
    outerArmsAngle outerArmsAngle,
    outerArmsLength outerArmsLength) {

    m_innerArmsAngle = innerArmsAngle;
    m_innerArmsLength = innerArmsLength;
    m_outerArmsAngle = outerArmsAngle;
    m_outerArmsLength = outerArmsLength;

    addCommands(new setInnerAngle(m_innerArmsAngle, 15));
    addCommands(new ParallelCommandGroup(           // reach up and slightly out with the inner arms
      new setOuterLength(m_outerArmsLength, 1260),
      new setInnerLength(m_innerArmsLength, 1000),   
      //new setInnerAngle(m_innerArmsAngle, 0),
      new setOuterAngle(m_outerArmsAngle, -25)));
    addCommands(new setInnerAngle(m_innerArmsAngle, -5)); // move inner arms back to hook bar
    addCommands(new setInnerLength(m_innerArmsLength, 0));  // lift robot with inner and angle outer forward
    addCommands(new ParallelCommandGroup(
      new setOuterAngle(m_outerArmsAngle, -50),
      new setInnerAngle(m_innerArmsAngle, 10)));
    addCommands(new ParallelCommandGroup(           
      new setInnerLength(m_innerArmsLength, 1000),
      new setOuterLength(m_outerArmsLength, 500)));
    addCommands(new setInnerLength(m_innerArmsLength, 250));
    addCommands(new ParallelCommandGroup(
      new setInnerLength(m_innerArmsLength, 0),
      new setOuterLength(m_outerArmsLength, 0),
      new setInnerAngle(m_innerArmsAngle, 0),
      new setOuterAngle(m_outerArmsAngle, 10))); // trying to make it more level.
                                                 // was 5 so if it causes problems change it back
  }
}

