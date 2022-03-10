package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    
    private MotorController m_intake;
    private MotorController m_climb;
    private MotorController m_shoot; 

    public Intake () {
        m_intake = new Spark(1);
        m_climb = new Spark(2);
        m_shoot = new Spark(7);
    }

    public void runIntake () {
        m_intake.set(1);
        m_climb.set(-1);
    }

    public void stopIntake () {
        m_intake.set(0);
        m_climb.set(0);
    }

    public void runShooter () {
        m_shoot.set(1);
    }

    public void stopShooter () {
        m_shoot.set(0);
    }
}
