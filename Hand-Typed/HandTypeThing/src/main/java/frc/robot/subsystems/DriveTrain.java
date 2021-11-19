package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {

    SpeedControllerGroup left, right;

    SpeedController hdrive;

    DifferentialDrive drive;

    public DriveTrain(SpeedControllerGroup left, SpeedControllerGroup right, DifferentialDrive drive, SpeedController hdrive) {

        this.left = left;
        this.right = right;
        this.drive = drive;
        this.hdrive = hdrive;
    }

    public void TakeJoyInput(Joystick joy) {
        drive.arcadeDrive(joy.getY(), joy.getZ());
        hdrive.set(joy.getX());
    }

    public void moveTank(double leftspeed, double rightspeed) {
        left.set(leftspeed);
        right.set(rightspeed);
    } 
    public void stop() {
        left.stopMotor();
        right.stopMotor();
        
    }
}
