// Source code is decompiled from a .class file using FernFlower decompiler.
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BeefCake extends SubsystemBase {
   private final VictorSPX intake = new VictorSPX(5);

   public BeefCake() {
      this.intake.setInverted(false);
   }

   public void periodic() {
   }

   public void intakeOn(double speed) {
      this.intake.set(VictorSPXControlMode.PercentOutput, speed);
   }

   public void intakeOff() {
      this.intake.set(VictorSPXControlMode.PercentOutput, 0.0);
   }

   public void cancelCommands() {
      CommandScheduler.getInstance().cancelAll();
   }
}
