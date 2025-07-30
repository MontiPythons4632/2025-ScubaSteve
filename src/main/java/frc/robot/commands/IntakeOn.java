// Source code is decompiled from a .class file using FernFlower decompiler.
package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.BeefCake;

public class IntakeOn extends Command {
   private final BeefCake beefCake;
   private final XboxController controller;
   private final boolean isAutonomous;
   private final Timer timer = new Timer();
   // private static final double IntakeSpeedMultiplier = 0.4;

   public IntakeOn(BeefCake subsystem, XboxController controller, boolean isAutonomous) {
      this.beefCake = subsystem;
      this.controller = controller;
      this.isAutonomous = isAutonomous;
      this.addRequirements(new Subsystem[]{this.beefCake});
   }

   public void initialize() {
      if (this.isAutonomous) {
         this.timer.reset();
         this.timer.start();
         this.beefCake.intakeOn(-0.35);
      }

   }

   public void execute() {
      if (!this.isAutonomous) {
         double joystickValue = this.controller.getRawAxis(1);
         double intakeSpeed = joystickValue * 0.4;
         this.beefCake.intakeOn(intakeSpeed);
      }

   }

   public void end(boolean interrupted) {
      this.beefCake.intakeOff();
   }

   public boolean isFinished() {
      return this.isAutonomous && this.timer.hasElapsed(1.0);
   }
}
