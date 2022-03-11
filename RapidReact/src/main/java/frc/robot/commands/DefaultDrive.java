package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class DefaultDrive extends CommandBase {
    
    private final DriveBase m_driveBase;
    private final DoubleSupplier m_forwardPower;
    private final DoubleSupplier m_rotatePower;

    private double m_currentForwardPower = 0.0, m_currentRotatePower = 0.0;

    private final double STEP_SIZE = 0.01;

    public DefaultDrive (DriveBase driveBase, DoubleSupplier forwardPower, DoubleSupplier rotatePower) {
        m_driveBase = driveBase;
        m_forwardPower = forwardPower;
        m_rotatePower = rotatePower;

        addRequirements(driveBase);
    }

    @Override
    public void execute () {
        if (Math.abs(m_currentForwardPower - m_forwardPower.getAsDouble()) < STEP_SIZE) {
            m_currentForwardPower += Math.abs(m_forwardPower.getAsDouble() - m_currentForwardPower)/(m_forwardPower.getAsDouble() - m_currentForwardPower) * STEP_SIZE;
        }

        if (Math.abs(m_currentRotatePower - m_rotatePower.getAsDouble()) < STEP_SIZE) {
            m_currentRotatePower += Math.abs(m_rotatePower.getAsDouble() - m_currentRotatePower)/(m_rotatePower.getAsDouble() - m_currentRotatePower) * STEP_SIZE;
        }

        m_driveBase.arcadeDrive(m_currentForwardPower, m_currentRotatePower);
    }
}
