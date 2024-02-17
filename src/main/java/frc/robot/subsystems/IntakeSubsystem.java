package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase
{
    public CANSparkMax grab1_motor;
    public CANSparkMax grab2_motor;
    public CANSparkMax middle_motor;

    public IntakeSubsystem()
    {
        grab1_motor = new CANSparkMax(Constants.Intake.grab1_deviceID, MotorType.kBrushless);
        grab2_motor = new CANSparkMax(Constants.Intake.grab2_deviceID, MotorType.kBrushless);
        middle_motor = new CANSparkMax(Constants.Intake.middle_deviceID, MotorType.kBrushless);
        grab1_motor.setInverted(true);
        grab2_motor.setInverted(true);
        middle_motor.setInverted(true); 
        grab1_motor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        grab2_motor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        middle_motor.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }

    public void setIntake(double speed)
    {
        grab1_motor.set(speed);
        grab2_motor.set(speed);
        middle_motor.set(speed);
    }
}