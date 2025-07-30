package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.BeefCake;
import frc.robot.subsystems.Drive;

//Drives forward, drops coral

public class AutoCenterPosition extends SequentialCommandGroup {
   public AutoCenterPosition(Drive drive, BeefCake beefCake) {
      super(new Command[]{new DriveForwardXSeconds(drive, DriveConstants.kAutoStraightPathTime, DriveConstants.kAutoStraightSpeed), new IntakeOn(beefCake, (XboxController)null, true)});
   }
}
