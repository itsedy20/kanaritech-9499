// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;
import frc.robot.RobotContainer;

public class powertrain extends SubsystemBase {
  /** Creates a new powertrain. */
  private final CANSparkMax left1 = new CANSparkMax(chasisPorts.left, MotorType.kBrushless);
  private final CANSparkMax left2 = new CANSparkMax(chasisPorts.left2, MotorType.kBrushless);
  private final CANSparkMax right1 = new CANSparkMax(chasisPorts.right, MotorType.kBrushless);
  private final CANSparkMax right2 = new CANSparkMax( chasisPorts.right2, MotorType.kBrushless);
   
  private DifferentialDrive arcade;

  public powertrain() {
   
  left1.restoreFactoryDefaults();
  left2.restoreFactoryDefaults();
  right1.restoreFactoryDefaults();
  right2.restoreFactoryDefaults();
  
  left1.setInverted(true);
  left2.setInverted(true);
  right1.setInverted(false);
  right2.setInverted(false);

  left2.follow(left1);
  right2.follow(right1);

  right1.setIdleMode(IdleMode.kBrake);
  right2.setIdleMode(IdleMode.kBrake);
  left1.setIdleMode(IdleMode.kBrake);
  left2.setIdleMode(IdleMode.kBrake);

  arcade = new DifferentialDrive(left1, right1);

  }

  public void powertrainoff(boolean coast){

    if(coast == true){
  right1.setIdleMode(IdleMode.kCoast);
  right2.setIdleMode(IdleMode.kCoast);
  left1.setIdleMode(IdleMode.kCoast);
  left2.setIdleMode(IdleMode.kCoast);
  }
  else{
  right1.setIdleMode(IdleMode.kBrake);
  right2.setIdleMode(IdleMode.kBrake);
  left1.setIdleMode(IdleMode.kBrake);
  left2.setIdleMode(IdleMode.kBrake);
  }
  }
  
  public Command ArcadeCommand(){
    return run(()->{
    arcade.arcadeDrive(RobotContainer.controller1.getRightTriggerAxis() - RobotContainer.controller1.getLeftTriggerAxis(), 
    RobotContainer.controller1.getRightX());
    
    });
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
