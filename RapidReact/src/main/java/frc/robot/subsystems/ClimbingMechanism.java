                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbingMechanism extends SubsystemBase {
    

    private MotorController m_climbLeft;
    private MotorController m_climbRight;

    public ClimbingMechanism () {
        m_climbRight = new Spark(3);
        m_climbLeft = new Spark(4);

    }

    public void raise () {
        m_climbRight.set(1);
        m_climbLeft.set(1);
    }

    public void lower () {
        m_climbRight.set(-1);
        m_climbLeft.set(-1);
    }

    public void stop () {
        m_climbRight.set(0);
        m_climbLeft.set(0);
    }
}
