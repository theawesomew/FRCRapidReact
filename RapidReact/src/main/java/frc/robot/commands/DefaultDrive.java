package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class DefaultDrive extends CommandBase {
    
    private final DriveBase m_driveBase;
    private final DoubleSupplier m_forwardPower;
    private final DoubleSupplier m_rotatePower;

    public DefaultDrive (DriveBase driveBase, DoubleSupplier forwardPower, DoubleSupplier rotatePower) {
        m_driveBase = driveBase;
        m_forwardPower = forwardPower;
        m_rotatePower = rotatePower;

        addRequirements(driveBase);
    }

    @Override
    public void execute () {
        double[] powers = calculate(m_forwardPower, m_rotatePower, 1.5);

       // System.out.println(powers[0] + " " + powers[1]);

        m_driveBase.arcadeDrive(powers[0], powers[1]);
    }

    private double[] calculate (DoubleSupplier forwardSupplier, DoubleSupplier rotateSupplier, double div) {
        System.out.println("TYest");
        double forward = forwardSupplier.getAsDouble() / div;
        double rotate = rotateSupplier.getAsDouble() / div;
        return new double[] {forward, rotate};
    }
}
