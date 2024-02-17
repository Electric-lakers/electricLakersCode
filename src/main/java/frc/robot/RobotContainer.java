// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import frc.robot.commands.driveCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.MecanumDriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.intakeCommand;

public class RobotContainer {
  
    
    public final static XboxController Driver = new XboxController(0); //Driver defined as XboxController with port 0
    public final static XboxController Operator = new XboxController(1); //Operator defined as XboxController with port 1
    public final static double leftJoystickX = Driver.getRawAxis(XboxController.Axis.kLeftX.value);
    public final static double leftJoystickY = Driver.getRawAxis(XboxController.Axis.kLeftY.value);
    public final static double rightJoystickX = Driver.getRawAxis(XboxController.Axis.kRightX.value);


        //Operator Buttons
    public final JoystickButton topIntake = new JoystickButton(Operator, XboxController.Button.kA.value);
        /*Subsystems */
    public final MecanumDriveSubsystem m_driveSubsystem = new MecanumDriveSubsystem();
    public final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
    public final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
        public RobotContainer() {

            
        //button commands
        
    }               
     

// Configure the button bindings
public void configureBindings(){

// Set default commands
m_driveSubsystem.setDefaultCommand(
    new driveCommand(
            Operator.getRawAxis(XboxController.Axis.kLeftY.value),
            Operator.getRawAxis(XboxController.Axis.kLeftX.value),
            Operator.getRawAxis(XboxController.Axis.kRightX.value),
          m_driveSubsystem
        ));



m_intakeSubsystem.setDefaultCommand(
    new intakeCommand(
         Operator.getRawAxis(XboxController.Axis.kRightTrigger.value), 
        m_intakeSubsystem
        
    )
);

((Subsystem) m_shooterSubsystem).setDefaultCommand(
    new ShootCommand(
         Operator.getRawAxis(XboxController.Axis.kLeftTrigger.value),
        m_shooterSubsystem
    )
);
topIntake.whileTrue(new ShootCommand(.3, m_shooterSubsystem));
}
}