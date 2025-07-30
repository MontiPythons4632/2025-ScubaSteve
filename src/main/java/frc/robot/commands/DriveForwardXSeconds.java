// Source code is decompiled from a .class file using FernFlower decompiler.
package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Drive;


//**beyond cooked, don't use this command!!!!!!!**


public class DriveForwardXSeconds extends Command {
   private final Drive m_drive;
   private final double speed;
   private final double duration;
   private final Timer timer = new Timer();

   public DriveForwardXSeconds(Drive subsystem, double timeSeconds, double speed) {
      this.m_drive = subsystem;
      this.duration = timeSeconds;
      this.speed = speed;
      this.addRequirements(new Subsystem[]{subsystem});
   }

   public void initialize() {
      this.timer.reset();
      this.timer.start();
      System.out.println("Starting Drive for " + this.duration + " seconds.");
   }

   public void execute() {
      this.m_drive.arcade(this.speed, 0.0);
   }

   public void end(boolean interrupted) {
      this.m_drive.arcade(0.0, 0.0);
      System.out.println("Drive Stopped.");
   }

   public boolean isFinished() {
      return this.timer.get() >= this.duration;
   }
}
