package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbingMechanism extends SubsystemBase {
    

    private MotorController m_climb;

    public ClimbingMechanism () {
        m_climb = new Spark(3);
    }

    public void raise () {
        m_climb.set(1);
    }

    public void lower () {
        m_climb.set(1);
    }

    public void stop () {
        m_climb.set(0);
    }
}
