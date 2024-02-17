package frc.robot.subsystems;

import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
public class ShooterSubsystem {
    public CANSparkMax bottemShooter = new CANSparkMax(Constants.ShooterIds.BottemShooter_ID, MotorType.kBrushless);
    public CANSparkMax UpperShooter = new CANSparkMax(Constants.ShooterIds.TopShooter_ID, MotorType.kBrushless);

    public ShooterSubsystem(){
        bottemShooter.restoreFactoryDefaults();
        UpperShooter.restoreFactoryDefaults();
    }
    
    public void setShooter(double speed){
        bottemShooter.set(speed);
        UpperShooter.set(speed);
    }
}
