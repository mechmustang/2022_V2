// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.commands.driveStraight;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.loader;
import frc.robot.subsystems.outerArmsAngle;
import frc.robot.subsystems.outerArmsLength;
import frc.robot.subsystems.shooter;
import frc.robot.subsystems.grabber;
import frc.robot.subsystems.innerArmsAngle;
import frc.robot.subsystems.innerArmsLength;
import frc.robot.Constants.*;
import frc.robot.commands.runGrabber;
import frc.robot.commands.runLoader;
import frc.robot.commands.runShooter;
import frc.robot.commands.shutDownShooting;
import frc.robot.commands.stopLoader;
import frc.robot.commands.testArms;

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
  private final shooter m_shooterBack = new shooter();
  private final loader m_loader = new loader();
  private final grabber m_grabber = new grabber();
  private final outerArmsLength m_outerArmsLength = new outerArmsLength();
  private final outerArmsAngle m_outerArmsAngle = new outerArmsAngle();
  private final innerArmsLength m_innerArmsLength = new innerArmsLength();
  private final innerArmsAngle m_innerArmsAngle = new innerArmsAngle();
  private final testArms m_autoCommand = new testArms(
    m_innerArmsAngle, 
    m_innerArmsLength, 
    m_outerArmsAngle, 
    m_outerArmsLength);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    configureButtonBindings();
    
    m_chassis.setDefaultCommand(
      new RunCommand(() -> m_chassis
        .arcadeDrive(m_driveController.getY(), 
                     m_driveController.getX()), 
                     m_chassis));
    m_outerArmsAngle.setDefaultCommand(
      new RunCommand(() -> m_outerArmsAngle
        .move(m_systemController.getLeftY()), m_outerArmsAngle));
    m_outerArmsLength.setDefaultCommand(
      new RunCommand(() -> m_outerArmsLength
        .move(m_systemController.getLeftX()), m_outerArmsLength));
    m_innerArmsAngle.setDefaultCommand(
      new RunCommand(() -> m_innerArmsAngle
        .move(m_systemController.getRightY()), m_innerArmsAngle));
    m_innerArmsLength.setDefaultCommand(
      new RunCommand(() -> m_innerArmsLength
        .move(m_systemController.getRightX()), m_innerArmsLength));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    final JoystickButton xBoxX = new JoystickButton(m_systemController, 1);
    final JoystickButton xBoxA = new JoystickButton(m_systemController, 2);
    final JoystickButton xBoxB = new JoystickButton(m_systemController, 3);
    final JoystickButton trigger = new JoystickButton(m_driveController, 1);
    final JoystickButton xBoxY = new JoystickButton(m_systemController, 4);
    

    xBoxX.whenPressed(new runGrabber(m_grabber));
    xBoxA.whileHeld(new runLoader(m_loader));
    xBoxA.whenReleased(new stopLoader(m_loader));
    xBoxB.whileHeld(new runShooter(m_shooterBack, k_shooter.frontShooterSpeedRPM, k_shooter.backShooterSpeedRPM));
    xBoxB.whenReleased(new runShooter(m_shooterBack, k_shooter.frontIdleSpeedRPM, k_shooter.backIdleSpeedRPM));
    xBoxY.whenPressed(new shutDownShooting(m_shooterBack, m_grabber));
    trigger.whenPressed(() -> m_chassis.setMaxOutput(0.5)).whenReleased(() -> m_chassis.setMaxOutput(.8));

    
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
