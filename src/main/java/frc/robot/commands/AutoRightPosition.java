// Source code is decompiled from a .class file using FernFlower decompiler.
package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.BeefCake;
import frc.robot.subsystems.Drive;

//forward, turn left, forward, drop coral


public class AutoRightPosition extends SequentialCommandGroup {
   public AutoRightPosition(Drive drive, BeefCake beefCake) {
      super(new Command[]{new DriveForwardXSeconds(drive, 0.65, 0.7), new TurnXDegrees(drive, 30.0), new DriveForwardXSeconds(drive, 5.5, 0.7), new IntakeOn(beefCake, (XboxController)null, true)});
   }
}
