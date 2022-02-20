// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class testSpark extends SubsystemBase {
  /** Creates a new testSpark. */
  public int CanID = 10;
  public double kP = 0.00007;
  public double kI = 0;
  public double kD = 0;
  public double kIz = 0;
  public double kFF = 0.002;
  public double kMaxOutput = 1; 
  public double kMinOutput = -1;

  public CANSparkMax testMotor;
  public SparkMaxPIDController testPID;
  public RelativeEncoder testEncoder;

  public boolean MotorReversed;
  public boolean EncoderReversed;

  public testSpark() {
    testMotor = new CANSparkMax(CanID, MotorType.kBrushless);
    
    testMotor.setInverted(MotorReversed);
    testEncoder.setInverted(EncoderReversed);
    
    testPID = testMotor.getPIDController();
    testEncoder = testMotor.getEncoder();

    testPID.setP(kP);
    testPID.setI(kI);
    testPID.setD(kD);
    testPID.setIZone(kIz);
    testPID.setFF(kFF);
    testPID.setOutputRange(kMinOutput, kMaxOutput);
    
  }

  public void setPosition(double rev) {
    testPID.setReference(rev, CANSparkMax.ControlType.kPosition);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
