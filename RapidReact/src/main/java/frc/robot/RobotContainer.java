package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DefaultDrive;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Intake;

public class RobotContainer {

    private DriveBase m_driveBase;
    private Intake m_intake;

    private XboxController m_controller = new XboxController(0);

    public RobotContainer () {
        m_driveBase = new DriveBase();
        m_intake = new Intake();

        m_driveBase.setDefaultCommand(new DefaultDrive(m_driveBase, 
                                    () -> m_controller.getRawAxis(1), 
                                    () -> m_controller.getRawAxis(5)));

        configureButtonBindings();
    }

    public void configureButtonBindings () {
       new JoystickButton(m_controller, 1).toggleWhenPressed(new StartEndCommand(m_intake::runIntake, m_intake::stopIntake, m_intake));

       new JoystickButton(m_controller, 2).whenPressed(new InstantCommand(m_intake::runShooter, m_intake));
       new JoystickButton(m_controller, 2).whenReleased(new InstantCommand(m_intake::stopShooter, m_intake));
    }
}
