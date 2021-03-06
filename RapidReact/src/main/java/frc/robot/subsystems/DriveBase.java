package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBase extends SubsystemBase {
    
    private MotorController m_leftDrive;
    private MotorController m_rightDrive;
    private DifferentialDrive m_differentialDrive;

    public DriveBase () {
        m_leftDrive = new PWMSparkMax(0);
        m_rightDrive = new PWMSparkMax(9);

        m_leftDrive.setInverted(true);

        m_differentialDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
        m_differentialDrive.setSafetyEnabled(false);
    }

    public void arcadeDrive (double leftPower, double rightPower) {
        m_differentialDrive.arcadeDrive(leftPower, rightPower);
    }

    public void reverse () {
        m_differentialDrive.arcadeDrive(-0.5, 0.0);
    }

    public void stop () {
        m_differentialDrive.arcadeDrive(0, 0);
    }
}
