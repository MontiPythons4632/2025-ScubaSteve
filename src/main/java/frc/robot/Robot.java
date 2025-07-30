// Source code is decompiled from a .class file using FernFlower decompiler.
package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
   private Command m_autonomousCommand;
   private RobotContainer m_robotContainer;

   public Robot() {
   }

   public void robotInit() {
      this.m_robotContainer = new RobotContainer();
      CameraServer.startAutomaticCapture();
   }

   public void robotPeriodic() {
      CommandScheduler.getInstance().run();
   }

   public void disabledInit() {
      this.m_robotContainer.allStop();
      CommandScheduler.getInstance().cancelAll();
   }

   public void disabledPeriodic() {
   }

   public void autonomousInit() {
      this.m_autonomousCommand = this.m_robotContainer.getAutonomousCommand();
      if (this.m_autonomousCommand != null) {
         this.m_autonomousCommand.schedule();
      }

   }

   public void autonomousPeriodic() {
   }

   public void teleopInit() {
      if (this.m_autonomousCommand != null) {
         this.m_autonomousCommand.cancel();
      }

   }

   public void teleopPeriodic() {
      CommandScheduler.getInstance().run();
   }

   public void testInit() {
      CommandScheduler.getInstance().cancelAll();
   }

   public void testPeriodic() {
   }
}
