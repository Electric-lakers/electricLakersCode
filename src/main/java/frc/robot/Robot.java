// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  Joystick main_joystick;
  Joystick nd2_joystick;

  CANSparkMax fl_motor;
  CANSparkMax fr_motor;
  CANSparkMax bl_motor;
  CANSparkMax br_motor;
  CANSparkMax grab1_motor;
  CANSparkMax grab2_motor;
  CANSparkMax middle_motor;
  CANSparkMax btmL_motor;
  CANSparkMax uprL_motor;

  private static final int fl_deviceID = 1;
  private static final int fr_deviceID = 2;
  private static final int bl_deviceID = 3;
  private static final int br_deviceID = 4;
  private static final int grab1_deviceID = 9;
  private static final int grab2_deviceID = 8;
  private static final int middle_deviceID = 5;
  private static final int btmL_deviceID = 6; //shooter motor
  private static final int uprL_deviceID = 7; //shooter motor

  private MecanumDrive mecanum_drive;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    nd2_joystick = new Joystick(1);
    
    
    main_joystick = new Joystick(0);
    main_joystick.setXChannel(4);
    main_joystick.setYChannel(1);
    main_joystick.setTwistChannel(0);

    fl_motor = new CANSparkMax(fl_deviceID, MotorType.kBrushless);
    fr_motor = new CANSparkMax(fr_deviceID, MotorType.kBrushless);
    bl_motor = new CANSparkMax(bl_deviceID, MotorType.kBrushless);
    br_motor = new CANSparkMax(br_deviceID, MotorType.kBrushless);
    grab1_motor = new CANSparkMax(grab1_deviceID, MotorType.kBrushless);
    grab2_motor = new CANSparkMax(grab2_deviceID, MotorType.kBrushless);
    middle_motor = new CANSparkMax(middle_deviceID, MotorType.kBrushless);
    btmL_motor = new CANSparkMax(btmL_deviceID, MotorType.kBrushless);
    uprL_motor = new CANSparkMax(uprL_deviceID, MotorType.kBrushless);
    
    fl_motor.restoreFactoryDefaults();
    fr_motor.restoreFactoryDefaults();
    bl_motor.restoreFactoryDefaults();
    br_motor.restoreFactoryDefaults();
    grab1_motor.restoreFactoryDefaults();
    grab2_motor.restoreFactoryDefaults();
    middle_motor.restoreFactoryDefaults();
    btmL_motor.restoreFactoryDefaults();
    uprL_motor.restoreFactoryDefaults();
    fl_motor.setClosedLoopRampRate(0.5);
    fr_motor.setClosedLoopRampRate(0.5);
    bl_motor.setClosedLoopRampRate(0.5);
    br_motor.setClosedLoopRampRate(0.5);

    fl_motor.setInverted(true);
    fr_motor.setInverted(false);
    bl_motor.setInverted(true);
    br_motor.setInverted(false);
    grab1_motor.setInverted(true);
    grab2_motor.setInverted(true);
    middle_motor.setInverted(true);  
    btmL_motor.setInverted(false);
    uprL_motor.setInverted(false);
    //robot_drive = new DifferentialDrive(bl_motor, br_motor);
    mecanum_drive = new MecanumDrive(fl_motor, bl_motor, fr_motor, br_motor);
  }
  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    double leftTrigger = nd2_joystick.getRawAxis(2);
    double right_trigger =  nd2_joystick.getRawAxis(3);

    grab1_motor.set(leftTrigger);
    grab2_motor.set(leftTrigger);
    middle_motor.set(leftTrigger);
    btmL_motor.set(right_trigger);
    uprL_motor.set(right_trigger);


//test
    //robot_drive.tankDrive(main_joystick.getY(), main_joystick.getY());
    double x = main_joystick.getX();
    double y = main_joystick.getY();
    double rotate = main_joystick.getTwist();

    mecanum_drive.driveCartesian(y, -x, -rotate);
  }
  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
