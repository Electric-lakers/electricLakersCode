package frc.robot.subsystems;

import frc.robot.RobotContainer;
import frc.robot.commands.driveCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class MecanumDriveSubsystem extends SubsystemBase {
    private final frc.robot.commands.driveCommand m_driveCommand;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
public final CANSparkMax frontLeftMotor = new CANSparkMax(Constants.DriveIds.FL_ID, MotorType.kBrushless);
public final CANSparkMax rearLeftMotor = new CANSparkMax(Constants.DriveIds.RL_ID, MotorType.kBrushless);
public final CANSparkMax frontRightMotor = new CANSparkMax(Constants.DriveIds.FR_ID, MotorType.kBrushless);
public final CANSparkMax rearRightMotor = new CANSparkMax(Constants.DriveIds.RR_ID, MotorType.kBrushless);

public MecanumDriveSubsystem() {
    this.m_driveCommand = null;
    frontLeftMotor.restoreFactoryDefaults();
    rearLeftMotor.restoreFactoryDefaults();
    frontRightMotor.restoreFactoryDefaults();
    rearRightMotor.restoreFactoryDefaults();
    frontLeftMotor.setInverted(true);
    rearLeftMotor.setInverted(true);
    
}



    




public void driveCommand(double JoyLx, double JoyLy, double JoyRx) {
    frontLeftMotor.set(JoyLy + JoyLx + JoyRx);
    rearLeftMotor.set(JoyLy - JoyLx + JoyRx);
    frontRightMotor.set(JoyLy - JoyLx - JoyRx);
    rearRightMotor.set(JoyLy + JoyLx - JoyRx);
}
}






 