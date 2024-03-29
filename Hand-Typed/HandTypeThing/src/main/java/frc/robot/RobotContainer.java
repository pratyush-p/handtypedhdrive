// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static SpeedController leftTop, leftBottom, rightTop, rightBottom;
  public static SpeedController hdrivemotor;
  public static SpeedControllerGroup left, right;

  public static DriveTrain driveTrain;

  public static DifferentialDrive drive;

  public static Joystick joy;
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    leftTop = new WPI_VictorSPX(Constants.LEFT1);
    leftBottom = new WPI_VictorSPX(Constants.LEFT2);
    rightTop = new WPI_VictorSPX(Constants.RIGHT1);
    rightBottom = new WPI_VictorSPX(Constants.RIGHT2);
    hdrivemotor = new WPI_VictorSPX(Constants.HDRIVE);

    drive = new DifferentialDrive(left, right);
    driveTrain = new DriveTrain(left, right, drive, hdrivemotor);
    driveTrain.setDefaultCommand(new DriveWithJoystick());

    joy = new Joystick(0);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  public static DriveTrain getDriveTrain(){return driveTrain;}
  public static Joystick getJoystick(){return joy;}
}
