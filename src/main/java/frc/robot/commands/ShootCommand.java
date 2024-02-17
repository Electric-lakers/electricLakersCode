package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends Command 
{
    private ShooterSubsystem m_shooter;
    private double m_speed;
   
    public ShootCommand(double speed, ShooterSubsystem subsystem) 
    {
        m_speed = speed;
        m_shooter = subsystem;
    }
    
    @Override
    public void initialize() 
    {
    
    }

    @Override
    public void execute() 
    {
        m_shooter.ShootCommand(m_speed);
    }

    @Override
    public void end(boolean interrupted) 
    {
        m_shooter.ShootCommand(0.0);
    }
    
    @Override
    public boolean isFinished() { return false; }

    @Override
    public boolean runsWhenDisabled() { return false; }
}