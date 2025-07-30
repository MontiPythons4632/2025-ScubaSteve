// Source code is decompiled from a .class file using FernFlower decompiler.
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
   private WPI_TalonSRX leftFront = new WPI_TalonSRX(1);
   private WPI_VictorSPX leftBack = new WPI_VictorSPX(2);
   private WPI_VictorSPX rightFront;
   private WPI_TalonSRX rightBack;
   private DifferentialDrive differentialDrive;
   private double speedLimit;
   private double turnLimit;
   private double driveInvert = 1.0; //true or false
   private Encoder leftEncoder;
   private Encoder rightEncoder;
   private double leftDistanceTraveled; //never got encoders working
   private double rightDistanceTraveled;
   private PigeonIMU pigeon;
   private double curX;

   public Drive() {
      this.leftBack.follow(this.leftFront);
      this.leftFront.setInverted(false);
      this.leftBack.setInverted(InvertType.FollowMaster);
      this.rightFront = new WPI_VictorSPX(3);
      this.rightBack = new WPI_TalonSRX(4);
      this.rightBack.follow(this.rightFront);
      this.rightFront.setInverted(true);
      this.rightBack.setInverted(InvertType.FollowMaster);
      this.differentialDrive = new DifferentialDrive(this.leftFront, this.rightFront);
      this.differentialDrive.setSafetyEnabled(false);
      this.differentialDrive.setExpiration(0.3);
      this.differentialDrive.setMaxOutput(1.0);
      this.speedLimit = 0.8;
      this.turnLimit = 0.8;
      this.leftEncoder = new Encoder(6, 7);
      this.leftEncoder.reset();
      this.leftEncoder.setDistancePerPulse(0.07340169751378021);
      this.leftEncoder.setReverseDirection(false);
      this.rightEncoder = new Encoder(8, 9);
      this.rightEncoder.reset();
      this.rightEncoder.setDistancePerPulse(0.07340169751378021);
      this.rightEncoder.setReverseDirection(true);
      this.pigeon = new PigeonIMU(8);
      this.pigeon.configFactoryDefault();
      this.pigeon.setYaw(0.0);
      this.pigeon.setFusedHeading(0.0);
      this.leftDistanceTraveled = 0.0;
      this.rightDistanceTraveled = 0.0;
   }

   public double getDriveInvert() {
      return this.driveInvert;
   }

   public void setDriveInvert(double driveInvert) {
      this.driveInvert = driveInvert;
   }

   public void initDefaultCommand() {
      this.stop();
   }

   public void periodic() {
      this.leftDistanceTraveled = this.leftEncoder.getDistance();
      SmartDashboard.putNumber("Left Distance", this.leftDistanceTraveled);
      this.rightDistanceTraveled = this.rightEncoder.getDistance();
      SmartDashboard.putNumber("Right Distance", this.rightDistanceTraveledVar());
      double[] ypr_deg = new double[3];
      this.pigeon.getYawPitchRoll(ypr_deg);
      this.curX = ypr_deg[0];
      SmartDashboard.putNumber("Drive Compass", this.pigeon.getAbsoluteCompassHeading());
      SmartDashboard.putNumber("Drive Yaw", this.curX);
      SmartDashboard.putNumber("Drive Speed", this.speedLimit);
      SmartDashboard.putNumber("Turn Speed", this.turnLimit);
   }

   public void arcade(double speed, double direction) {
      this.differentialDrive.arcadeDrive(speed * this.speedLimit * this.driveInvert, direction * this.turnLimit);
   }

   public double getDriveMode() {
      return this.driveInvert;
   }

   public double getDistanceTraveled() {
      return (this.leftDistanceTraveled + this.rightDistanceTraveled) / 2.0;
   }

   public double getCurrentHeading() {
      return this.curX;
   }

   public double getHeading() {
      return Math.IEEEremainder(this.curX, 360.0) * 1.0;
   }

   public DifferentialDriveWheelSpeeds getWheelSpeeds() {
      return new DifferentialDriveWheelSpeeds(this.leftEncoder.getRate(), this.rightEncoder.getRate());
   }

   public void stop() {
      this.arcade(0.0, 0.0);
   }

   public double rightDistanceTraveledVar() {
      return this.rightDistanceTraveled;
   }
}
