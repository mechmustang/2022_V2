// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class arm extends SubsystemBase {
  /** Creates a new arm. */
  public int CanIDLength;
  public int CanIDAngle;
  public double akP;
  public double akI;
  public double akD;
  public double akIz;
  public double akFF;
  public double akMaxOutput; 
  public double akMinOutput;
  public double lkP; 
  public double lkI;
  public double lkD;
  public double lkIz;
  public double lkFF;
  public double lkMaxOutput; 
  public double lkMinOutput;

  public CANSparkMax lengthMotor;
  public CANSparkMax angleMotor;
  public SparkMaxPIDController lengthPID;
  public SparkMaxPIDController anglePID;
  public RelativeEncoder lengthEncoder;
  public RelativeEncoder angleEncoder;

  public arm(int CanIDLength, 
             int CanIDAngle,
             double akP, 
             double akI,
             double akD,
             double akIz,
             double akFF,
             double akMaxOutput, 
             double akMinOutput,
             double lkP, 
             double lkI,
             double lkD,
             double lkIz,
             double lkFF,
             double lkMaxOutput, 
             double lkMinOutput) {
    this.CanIDLength = CanIDLength;
    this.CanIDAngle = CanIDAngle;
    this.akP = akP;
    this.akI = akI;
    this.akD = akD;
    this.akIz = akIz;
    this.akFF = akFF;
    this.akMaxOutput = akMaxOutput;
    this.akMinOutput = akMinOutput;
    this.lkP = lkP;
    this.lkI = lkI;
    this.lkD = lkD;
    this.lkIz = lkIz;
    this.lkFF = lkFF;
    this.lkMaxOutput = lkMaxOutput; 
    this.lkMinOutput = lkMinOutput;

    lengthMotor = new CANSparkMax(this.CanIDLength, MotorType.kBrushless);
    angleMotor = new CANSparkMax(this.CanIDAngle, MotorType.kBrushless);

    lengthMotor.restoreFactoryDefaults();
    angleMotor.restoreFactoryDefaults();

    lengthPID = lengthMotor.getPIDController();
    anglePID = angleMotor.getPIDController();

    lengthEncoder = lengthMotor.getEncoder();
    angleEncoder = angleMotor.getEncoder();

    lengthPID.setP(lkP);
    lengthPID.setI(lkI);
    lengthPID.setD(lkD);
    lengthPID.setIZone(lkIz);
    lengthPID.setFF(lkFF);
    lengthPID.setOutputRange(lkMinOutput, lkMaxOutput);

    anglePID.setP(akP);
    anglePID.setI(akI);
    anglePID.setD(akD);
    anglePID.setIZone(akIz);
    anglePID.setFF(akFF);
    anglePID.setOutputRange(akMinOutput, akMaxOutput);
  }

  public void haltArms() {
    lengthMotor.set(0);
    angleMotor.set(0);
  }

  public void homeArms() {
    lengthPID.setReference(0, CANSparkMax.ControlType.kPosition);
    anglePID.setReference(0, CANSparkMax.ControlType.kPosition);
  }

  public void setAngle(double angle) {
    // do some math to calibrate angle into a position
    double position = angle;
    anglePID.setReference(position, CANSparkMax.ControlType.kPosition);
  }

  public void setLength(double length) {
    // do some math to calibrate length into a postion
    double position = length;
    lengthPID.setReference(position, CANSparkMax.ControlType.kPosition);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
