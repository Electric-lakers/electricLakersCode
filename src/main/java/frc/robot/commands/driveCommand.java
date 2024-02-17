package frc.robot.commands;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.subsystems.MecanumDriveSubsystem;

public class driveCommand {
    private double FL;
    private double RL;
    private double FR;
    private double RR;
    private final MecanumDriveSubsystem m_driveSubsystem;

    public driveCommand(double FL, double RL, double FR, double RR)
    {
        this.m_driveSubsystem = new MecanumDriveSubsystem();
        
        m_driveSubsystem.frontLeftMotor.set(FL);
        m_driveSubsystem.rearLeftMotor.set(RL);
        m_driveSubsystem.frontRightMotor.set(FR);
        m_driveSubsystem.rearRightMotor.set(RR);
    }

    
} 
