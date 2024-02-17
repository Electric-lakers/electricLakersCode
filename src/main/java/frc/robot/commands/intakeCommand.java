package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class intakeCommand extends Command 
{
    private final IntakeSubsystem m_intake;
    private final double m_speed;

    public intakeCommand(double speed, IntakeSubsystem subsystem) 
    {
        m_speed = speed;
        m_intake = subsystem;
    }

    @Override
    public void initialize() {  }

    @Override
    public void execute() 
    {
        m_intake.intakeCommand(m_speed);
    }
    @Override
    public void end(boolean interrupted) 
    {
        
    }
    
    @Override
    public boolean isFinished() { return false; }

    @Override
    public boolean runsWhenDisabled() { return false; }
}