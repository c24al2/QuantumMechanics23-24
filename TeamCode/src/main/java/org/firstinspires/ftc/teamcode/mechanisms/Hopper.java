package org.firstinspires.ftc.teamcode.mechanisms;
import com.qualcomm.robotcore.hardware.Servo;

public class Hopper{
    private Servo hopperServo;
    private static final double PICKUP_POSITION = 0.4;
    private static final double DROP_POSITION = 0.13;

    public Hopper(Servo hopperServo) {
        this.hopperServo = hopperServo;
    }

    public void setPickupPosition() {
        hopperServo.setPosition(PICKUP_POSITION);
    }

    public void setDropPosition() {
        hopperServo.setPosition(DROP_POSITION);
    }
}
