// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.chassis;
import frc.robot.subsystems.arm;
import frc.robot.subsystems.shooter;
import frc.robot.Constants.innerArms;
import frc.robot.Constants.outerArms;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private final chassis m_chassis = new chassis();
  private final arm m_innerArm = new arm(innerArms.lengthCanID, 
                                         innerArms.angleCanID,
                                         innerArms.akP,
                                         innerArms.akI,
                                         innerArms.akD,
                                         innerArms.akIz,
                                         innerArms.akFF,
                                         innerArms.akMaxOutput,
                                         innerArms.akMinOutput,
                                         innerArms.lkP,
                                         innerArms.lkI,
                                         innerArms.lkD,
                                         innerArms.lkIz,
                                         innerArms.lkFF,
                                         innerArms.lkMaxOutput,
                                         innerArms.lkMinOutput);
  private final arm m_outerArm = new arm(outerArms.lengthCanID, 
                                         outerArms.angleCanID,
                                         outerArms.akP,
                                         outerArms.akI,
                                         outerArms.akD,
                                         outerArms.akIz,
                                         outerArms.akFF,
                                         outerArms.akMaxOutput,
                                         outerArms.akMinOutput,
                                         outerArms.lkP,
                                         outerArms.lkI,
                                         outerArms.lkD,
                                         outerArms.lkIz,
                                         outerArms.lkFF,
                                         outerArms.lkMaxOutput,
                                         outerArms.lkMinOutput);
  private final shooter m_shooter = new shooter();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_chassis);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
