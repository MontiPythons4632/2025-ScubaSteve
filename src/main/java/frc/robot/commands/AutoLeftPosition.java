// Source code is decompiled from a .class file using FernFlower decompiler.
package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.BeefCake;
import frc.robot.subsystems.Drive;


//forward, turn right, forward, drop coral

public class AutoLeftPosition extends SequentialCommandGroup {
   public AutoLeftPosition(Drive drive, BeefCake beefCake) {
      super(new Command[]{new DriveForwardXSeconds(drive, DriveConstants.kAutoAnglePathTime1, DriveConstants.kAutoAngledSpeed), new TurnXDegrees(drive, -30.0), new DriveForwardXSeconds(drive, DriveConstants.kAutoAnglePathTime2, 0.7), new IntakeOn(beefCake, (XboxController)null, true)});
   }
}
