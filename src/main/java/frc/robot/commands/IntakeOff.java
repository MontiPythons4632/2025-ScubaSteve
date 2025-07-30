// Source code is decompiled from a .class file using FernFlower decompiler.
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.BeefCake;

public class IntakeOff extends Command {
   private BeefCake beefCake;

   public IntakeOff(BeefCake subsystem) {
      this.beefCake = subsystem;
      this.addRequirements(new Subsystem[]{this.beefCake});
   }

   public void initialize() {
      this.beefCake.intakeOff();
   }

   public void execute() {
   }

   public void end(boolean interrupted) {
   }

   public boolean isFinished() {
      return false;
   }
}
