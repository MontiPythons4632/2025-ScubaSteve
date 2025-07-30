// Source code is decompiled from a .class file using FernFlower decompiler.
package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Drive;

//no idea what's going on here, im pretty sure chat wrote this


public class TurnXDegrees extends Command {
   private final Drive driveSubsystem;
   private double currX;
   private double initX;
   private double destX;
   private double degrees_to_turn;
   // private final double initSpeed = 0.75;

   public TurnXDegrees(Drive subsystem, double degrees) {
      this.addRequirements(new Subsystem[]{subsystem});
      this.driveSubsystem = subsystem;
      this.degrees_to_turn = degrees;
   }

   public void initialize() {
      this.initX = this.normalizeAngle(this.driveSubsystem.getCurrentHeading());
      this.destX = this.normalizeAngle(this.initX + this.degrees_to_turn);
      SmartDashboard.putNumber("Target Turn Angle", this.destX);
      System.out.println("Turning from " + this.initX + "\u00c2\u00b0 to " + this.destX + "\u00c2\u00b0");
   }

   public void execute() {
      this.currX = this.normalizeAngle(this.driveSubsystem.getCurrentHeading());
      double direction = this.shouldTurnLeft(this.initX, this.destX) ? 1.0 : -1.0;
      SmartDashboard.putNumber("Current Turn Angle", this.currX);
      this.driveSubsystem.arcade(0.0, direction * 0.75);
   }

   public void end(boolean interrupted) {
      this.driveSubsystem.arcade(0.0, 0.0);
      SmartDashboard.putString("Target Turn Angle", "Not Turning");
      System.out.println("Turn complete at " + this.currX + "\u00c2\u00b0");
   }

   public boolean isFinished() {
      this.currX = this.normalizeAngle(this.driveSubsystem.getCurrentHeading());
      double error = Math.abs(this.currX - this.destX);
      boolean done = error < 1.0 || error > 359.0;
      if (done) {
         System.out.println("Turn finished at " + this.currX + "\u00c2\u00b0");
      }

      return done;
   }

   private double normalizeAngle(double angle) {
      while(angle > 180.0) {
         angle -= 360.0;
      }

      while(angle <= -180.0) {
         angle += 360.0;
      }

      return angle;
   }

   private boolean shouldTurnLeft(double start, double target) {
      double diff = this.normalizeAngle(target - start);
      return diff > 0.0;
   }
}
