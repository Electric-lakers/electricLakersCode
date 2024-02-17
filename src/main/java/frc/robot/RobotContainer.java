// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import frc.robot.commands.driveCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.MecanumDriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

import java.sql.Driver;

import org.ejml.dense.block.MatrixOps_DDRB;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  
    
    public final static XboxController Driver = new XboxController(0); //Driver defined as XboxController with port 0
    public final static XboxController Operator = new XboxController(1); //Operator defined as XboxController with port 1
    public final static double leftJoystickX = Driver.getRawAxis(XboxController.Axis.kLeftX.value);
    public final static double leftJoystickY = Driver.getRawAxis(XboxController.Axis.kLeftY.value);
        public final static double rightJoystickX = Driver.getRawAxis(XboxController.Axis.kRightX.value);


        //Operator Buttons
        public final JoystickButton topIntake = new JoystickButton(Operator, XboxController.Button.kA.value);
        /*Subsystems */
    final MecanumDriveSubsystem m_driveSubsystem = new MecanumDriveSubsystem();
    final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
    final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
        public RobotContainer() {

            
        //button commands
        
    }               
     

/*Commands */
@SuppressWarnings("unused")
private void configureBindings() {
    m_driveSubsystem.driveCommand(leftJoystickX, leftJoystickY, rightJoystickX);
    m_intakeSubsystem.setIntake(Operator.getRawAxis(XboxController.Axis.kRightTrigger.value));
    m_shooterSubsystem.setShooter(Operator.getRawAxis(XboxController.Axis.kLeftTrigger.value));

    
}
}