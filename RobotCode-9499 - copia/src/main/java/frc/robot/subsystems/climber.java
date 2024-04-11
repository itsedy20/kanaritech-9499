// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class climber extends SubsystemBase {
  /** Creates a new climber. */
 private final Compressor compresor = new Compressor(2,PneumaticsModuleType.REVPH);

  private final DoubleSolenoid solenoid = new DoubleSolenoid(2, PneumaticsModuleType.REVPH, 2, 1);

  public climber() {
    compresor.enableAnalog(40, 110);
    solenoid.set(Value.kReverse);

  }
  public Command enable(){
    return runOnce(()->{
      solenoid.toggle();
    });
  }
  public Command disable(){
    return runOnce(()->{
      solenoid.set(Value.kReverse);
    });
  }
  public Command OFF(){
    return runOnce(()->{
      solenoid.set(Value.kReverse);
    });
  }
  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
