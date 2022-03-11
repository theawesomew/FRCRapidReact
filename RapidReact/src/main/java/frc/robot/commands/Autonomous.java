package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Intake;

public class Autonomous extends SequentialCommandGroup {

    private final DriveBase m_driveBase;
    private final Intake m_intake;

    public Autonomous (DriveBase driveBase, Intake intake) {

        m_driveBase = driveBase;
        m_intake = intake;

        addCommands(
            new StartEndCommand(m_intake::runIntake, m_intake::stopIntake, m_intake).withTimeout(5),
            new StartEndCommand(m_intake::runShooter, m_intake::stopShooter, m_intake).withTimeout(5)
        );

        addRequirements(driveBase, intake);
    }
}