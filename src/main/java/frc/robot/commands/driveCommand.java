package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MecanumDriveSubsystem;


public class driveCommand extends Command{
    private final MecanumDriveSubsystem m_driveSubsystem;
    private final double  m_forward;
    private final double m_strafe;
    private final double  m_rotation;

    public driveCommand(double  forward, double strafe, double rotation, MecanumDriveSubsystem driveSubsystem) {
        m_forward = forward;
        m_strafe = strafe;
        m_rotation = rotation;
        m_driveSubsystem = driveSubsystem;
        
    }



    @Override
    public void initialize() 
    {
    }

    @Override
    public void execute() 
    {
        m_driveSubsystem.driveCommand(m_forward, m_strafe, m_rotation);
    }

    @Override
    public boolean runsWhenDisabled() { return false; }
}
