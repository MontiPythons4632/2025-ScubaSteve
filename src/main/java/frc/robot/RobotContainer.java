// Source code is decompiled from a .class file using FernFlower decompiler.
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.AutoCenterPosition;
import frc.robot.commands.AutoLeaveStartingLine;
import frc.robot.commands.AutoLeftPosition;
import frc.robot.commands.AutoLeftPositionBackUp;
import frc.robot.commands.AutoRightPosition;
import frc.robot.commands.AutoRightPositionBackUp;
import frc.robot.commands.IntakeOn;
import frc.robot.subsystems.BeefCake;
import frc.robot.subsystems.Drive;
public class RobotContainer {
   private final SendableChooser<Command> autoChooser = new SendableChooser();
   XboxController XboxController1 = new XboxController(0);
   XboxController XboxController2 = new XboxController(1);
   private final Drive drive = new Drive();
   private final BeefCake beefCake = new BeefCake();

   public RobotContainer() {
      this.configureButtonBindings();
      this.drive.stop();
      this.drive.setDefaultCommand(new RunCommand(() -> {
         this.drive.arcade(this.XboxController1.getRawAxis(1) * -1.0, this.XboxController1.getRawAxis(4) * -1.0);
      }, new Subsystem[]{this.drive}));


      this.autoChooser.addOption("Center", new AutoCenterPosition(this.drive, this.beefCake));
      this.autoChooser.addOption("Left Pos", new AutoLeftPosition(this.drive, this.beefCake));
      this.autoChooser.addOption("Right Pos", new AutoRightPosition(this.drive, this.beefCake));
      this.autoChooser.addOption("Right Pos Back Up", new AutoRightPositionBackUp(this.drive, this.beefCake));
      this.autoChooser.addOption("Left Pos Back Up", new AutoLeftPositionBackUp(this.drive, this.beefCake));
      this.autoChooser.addOption("Leave Starting Line", new AutoLeaveStartingLine(this.drive, this.beefCake));
      this.autoChooser.addOption("Nothing", (Command)null);
      
      SmartDashboard.putData("autoChooser", this.autoChooser);

   }

   public void allStop() {
      this.drive.stop();
      CommandScheduler.getInstance().cancelAll();
   }

   private void configureButtonBindings() {
      System.out.println("Setting Bindings");
      this.beefCake.setDefaultCommand(new IntakeOn(this.beefCake, this.XboxController2, false));
   }

   public Command getAutonomousCommand() {
      return (Command)this.autoChooser.getSelected();
   }
}
