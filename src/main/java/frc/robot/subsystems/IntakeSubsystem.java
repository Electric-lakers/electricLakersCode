package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class IntakeSubsystem {
    public final CANSparkMax Grab1 = new CANSparkMax(Constants.IntakeIds.Grab1_ID, MotorType.kBrushless); 
    public final CANSparkMax Grab2 = new CANSparkMax(Constants.IntakeIds.Grab2_ID, MotorType.kBrushless);
    public final CANSparkMax Lift = new CANSparkMax(Constants.IntakeIds.Lift_ID, MotorType.kBrushless);

        public IntakeSubsystem()
        {
            Grab1.restoreFactoryDefaults();
            Grab2.restoreFactoryDefaults();
            Lift.restoreFactoryDefaults();
            Grab1.setInverted(true);
            Grab2.setInverted(true);
            Lift.setInverted(true);
        }

        public void setIntake(double speed){
            if (RobotContainer.Operator.getRawAxis(XboxController.Axis.kRightTrigger.value) > 0.1) {
                Grab1.set(1);
                Grab2.set(1);
                Lift.set(1);
            } else {
                Grab1.set(0);
                Grab2.set(0);
                Lift.set(0);
            }
        }
}