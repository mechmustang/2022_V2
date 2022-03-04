// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.driveStraight;
import frc.robot.subsystems.drive;
import frc.robot.Constants.*;
import frc.robot.commands.runGrabber;
import frc.robot.commands.runLoader;
import frc.robot.commands.runShooter;
import frc.robot.commands.shutDownShooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
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
  private final driveStraight m_autoCommand = new driveStraight();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    configureButtonBindings();
    
    m_chassis.setDefaultCommand(
      new RunCommand(() -> m_chassis
        .arcadeDrive(m_driveController.getY(), 
                     m_driveController.getX()), 
                     m_chassis));
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    final JoystickButton xBoxA = new JoystickButton(m_systemController, 1);
    final JoystickButton xBoxB = new JoystickButton(m_systemController, 2);
    final JoystickButton xBoxX = new JoystickButton(m_systemController, 3);
    final JoystickButton xBoxY = new JoystickButton(m_systemController, 4);

    xBoxA.whenPressed(new runGrabber());
    xBoxB.whenPressed(new runLoader());
    xBoxX.whenPressed(new runShooter());
    xBoxY.whenPressed(new shutDownShooter());

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
