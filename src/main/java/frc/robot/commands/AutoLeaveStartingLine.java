package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.BeefCake;
import frc.robot.subsystems.Drive;

//drives forward slightly for the auto points

public class AutoLeaveStartingLine extends SequentialCommandGroup {
   public AutoLeaveStartingLine(Drive drive, BeefCake beefCake) {
      super(new Command[]{new DriveForwardXSeconds(drive, DriveConstants.kLeaveStartingLineDriveTime, DriveConstants.kAutoStraightSpeed)});
   }
}
