package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class DefaultDrive extends CommandBase {
    
    private final DriveBase m_driveBase;
    private final DoubleSupplier m_leftDrive;
    private final DoubleSupplier m_rightDrive;

    public DefaultDrive (DriveBase driveBase, DoubleSupplier leftDrive, DoubleSupplier rightDrive) {
        m_driveBase = driveBase;
        m_leftDrive = leftDrive;
        m_rightDrive = rightDrive;

        addRequirements(driveBase);
    }

    @Override
    public void execute () {
        m_driveBase.arcadeDrive(m_leftDrive.getAsDouble(), m_rightDrive.getAsDouble());
    }
}
