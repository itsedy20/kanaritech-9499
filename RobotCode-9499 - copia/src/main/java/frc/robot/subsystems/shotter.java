// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shotter extends SubsystemBase {
  /** Creates a new shotter. */
  private final CANSparkMax m1,m2;
  public shotter() {
    m1 = new CANSparkMax(ShotterPorts.m1, MotorType.kBrushless);
    m2 = new CANSparkMax(ShotterPorts.m2, MotorType.kBrushless);

    m1.restoreFactoryDefaults();
    m2.restoreFactoryDefaults();

    m1.setIdleMode(IdleMode.kCoast);
    m2.setIdleMode(IdleMode.kCoast);
  } 

  public void setSpeed(double speed){
    m1.set(speed);
    m2.set(speed);
  }

  public Command shotpiece(){
    return run(()->{

      setSpeed(1);
    });
  }

   public Command intPiece(){
    return run(()->{

      setSpeed(-5);
    });
  }

     public Command neutral(){
    return run(()->{

      setSpeed(0);
    });
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
