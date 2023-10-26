package org.firstinspires.ftc.teamcode.mechanisms;
import com.qualcomm.robotcore.hardware.Servo;

public class Hopper{
    private Servo hopperServo;
    private static final double PICKUP_1_POSITION = 0.2;
    private static final double PICKUP_2_POSITION = 0.4;
    private static final double HANDOFF_POSITION = 0.8;

    public Hopper(Servo hopperServo) {
        this.hopperServo = hopperServo;
    }

    public void setPickup1Position() {
        hopperServo.setPosition(PICKUP_1_POSITION);
    }
    public void setPickup2Position() {hopperServo.setPosition(PICKUP_2_POSITION);}
    public void setDropPosition() {hopperServo.setPosition(HANDOFF_POSITION);}
}
