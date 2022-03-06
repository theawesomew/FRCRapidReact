package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.commands.DefaultDrive;
import frc.robot.subsystems.DriveBase;

public class RobotContainer {

    private DriveBase m_driveBase;

    private PS4Controller m_controller = new PS4Controller(0);

    public RobotContainer () {
        m_driveBase = new DriveBase();

        m_driveBase.setDefaultCommand(new DefaultDrive(m_driveBase, 
                                    () -> m_controller.getRawAxis(1), 
                                    () -> m_controller.getRawAxis(5)));
    }

    public void configureButtonBindings () {}
}
