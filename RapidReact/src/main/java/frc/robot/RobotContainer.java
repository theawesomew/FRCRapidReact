package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Autonomous;
import frc.robot.commands.DefaultDrive;
import frc.robot.subsystems.ClimbingMechanism;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Intake;

public class RobotContainer {

    private DriveBase m_driveBase;
    private Intake m_intake;
    private ClimbingMechanism m_climb;

    private XboxController m_controller = new XboxController(0);

    public RobotContainer () {
        m_driveBase = new DriveBase();
        m_intake = new Intake();
        m_climb = new ClimbingMechanism();

        m_driveBase.setDefaultCommand(new DefaultDrive(m_driveBase, 
                                    () -> -m_controller.getRawAxis(1)/4, 
                                    () -> m_controller.getRawAxis(4)/4));

        configureButtonBindings();
    }

    public void configureButtonBindings () {
       new JoystickButton(m_controller, 1).toggleWhenPressed(new StartEndCommand(m_intake::runIntake, m_intake::stopIntake, m_intake));

       new JoystickButton(m_controller, 2).whenPressed(new InstantCommand(m_intake::runShooter, m_intake));
       new JoystickButton(m_controller, 2).whenReleased(new InstantCommand(m_intake::stopShooter, m_intake));

       new Trigger(() -> (m_controller.getRawAxis(2) > 0.7)).whenActive(new InstantCommand(m_climb::raise, m_climb));
       new Trigger(() -> (m_controller.getRawAxis(2) > 0.7)).whenInactive(new InstantCommand(m_climb::stop, m_climb));

       new Trigger(() -> (m_controller.getRawAxis(3) > 0.7)).whenActive(new InstantCommand(m_climb::lower, m_climb));
       new Trigger(() -> (m_controller.getRawAxis(3) > 0.7)).whenInactive(new InstantCommand(m_climb::stop, m_climb));
    }

    public Command getAutonomousCommand () {
        return new Autonomous(m_driveBase, m_intake);
    }
}
