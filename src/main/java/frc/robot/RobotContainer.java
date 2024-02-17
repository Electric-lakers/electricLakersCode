package frc.robot;

import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;

import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.setIntake;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.XboxController;




public class RobotContainer {
    
    //Xbox controllers defining
    private final XboxController Driver = new XboxController(1);
    private final XboxController Operator = new XboxController(0);

    private final IntakeSubsystem m_intake = new IntakeSubsystem();

    private void configureBindings() {
        m_intake.setDefaultCommand(
            new setIntake(() -> Driver.getRawAxis(XboxController.getRawAxis.RightTrigger), m_intake)); // this is how you get the left stick y value and use it
    }
}
