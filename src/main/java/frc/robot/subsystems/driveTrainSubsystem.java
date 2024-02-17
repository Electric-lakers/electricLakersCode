package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class driveTrainSubsystem extends SubsystemBase {
    // Assuming you have 4 motors for the Mecanum drive
  
    private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(Constants.motorIDs.fl_deviceID, Constants.motorIDs.bl_deviceID);
    private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(Constants.motorIDs.fr_deviceID, Constants.motorIDs.br_deviceID);

    private final MecanumDrive mecanumDrive = new MecanumDrive(Constants.motorIDs.fl_deviceID, Constants.motorIDs.bl_deviceID, Constants.motorIDs.fr_deviceID, Constants.motorIDs.br_deviceID);

    public driveTrainSubsystem() {
        super();
    }

    public void drive(double ySpeed, double xSpeed, double zRotation) {
        mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}