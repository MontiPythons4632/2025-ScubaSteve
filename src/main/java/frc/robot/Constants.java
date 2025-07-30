package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public final class Constants {
    private Constants() {
    }

    public static final class AutoDriveConstants {
        public static final String path = "/home/lvuser/deploy/paths";

        private AutoDriveConstants() {
        }
    }

    public static final class BeefCakeConstants {
        public static final int kBeefCakeAll = 0; //debug, set to 0 for no console logs
        public static final int kDebugBeefCakeIntake = 0; //debug, set to 0 for no console logs
        public static final double kIntakeSpeedMultiplier = 0.4; //coral dropper intake speed

        private BeefCakeConstants() {
        }
    }

    public static final class DriveConstants {
        public static final int kDebugDriveAll = 0; //debug, set to 0 for no console logs
        public static final int kDebugDrive = 0; //debug, set to 0 for no console logs
        public static final double kDriveNorm = 0.8; //drive speed
        public static final double kTurnNorm = 0.8; //turn speed
        public static final double cpr = 256.8; //encoder clicks
        public static final double whd = 6.0; //wheel diameter ?


        public static final boolean kGyroReversed = false;
        public static final double ksVolts = 0.974;
        public static final double kvVoltSecondsPerMeter = 2.57;
        public static final double kaVoltSecondsSquaredPerMeter = 0.402;
        public static final double kMaxSpeedMetersPerSecond = 1.5;
        public static final double kMaxAccelerationMetersPerSecondSquared = 1.5;
        public static final double kTrackwidthMeters = 0.874;
        public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(kTrackwidthMeters);
        public static final double kRamseteB = 2.0;
        public static final double kRamseteZeta = 0.7;


        public static final double kAutoStraightSpeed = 0.65; //straight auto speed
        public static final double kAutoAngledSpeed = 0.7; //speed after turn in auto
        public static final double kAutoIntakeSpeed = -0.35; //intake speed in auto // -.35
        public static final double kAutoIntakeTime = 1.0;
        public static final double kAutoStraightPathTime = 3.0;
        public static final double kAutoAnglePathTime1 = 0.65;//turn auto speed for first movement
        public static final double kAutoAnglePathTime2 = 5.5;
        public static final double kAutoAnglePathTime3 = 3.0;
        public static final double kLeaveStartingLineDriveTime = 1.0;

        private DriveConstants() {
        }
    }
}
