// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.driveDistance;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.arm;
import frc.robot.subsystems.shooter;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private final Joystick m_driveController = new Joystick(k_chassis.kDriveControlStick);
  private final XboxController m_systemController = new XboxController(k_chassis.kSystemController);
  private final drive m_chassis = new drive();
  private final shooter m_shooter = new shooter();
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
                                         innerArms.lkMinOutput,
                                         innerArms.aMotorReversed,
                                         innerArms.aEncoderReversed,
                                         innerArms.lMotorReversed,
                                         innerArms.lEncoderReversed);
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
                                         outerArms.lkMinOutput,
                                         outerArms.aMotorReversed,
                                         outerArms.aEncoderReversed,
                                         outerArms.lMotorReversed,
                                         outerArms.lEncoderReversed);
  

  private final driveDistance m_autoCommand = new driveDistance(5);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_chassis.setDefaultCommand(
      new RunCommand(() -> m_chassis
        .arcadeDrive(m_driveController.getY(), 
                     m_driveController.getX()), 
                     m_chassis));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_systemController, Button.kA.value)
    .toggleWhenPressed(new StartEndCommand(
      m_shooter::startGrabber, 
      m_shooter::stopGrabber, 
      m_shooter));

    new JoystickButton(m_systemController, Button.kB.value)
    .toggleWhenPressed(new StartEndCommand(
      m_shooter::startShooter, 
      m_shooter::stopShooter, 
      m_shooter));
    
    new JoystickButton(m_systemController, Button.kRightBumper.value)
    .whenHeld(new InstantCommand(
      m_shooter::startLoader, m_shooter));

  }

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
