package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Servo;

public class Flipper {
    private Servo servo1;
    private Servo servo2;

    public static final double PICKUP_SERVO = 0.0;
    public static final double DROP_SERVO = 0.5;
    public static final double VERTICAL_SERVO = 1.0;

    public Flipper(Servo servo1, Servo servo2) {
        this.servo1 = servo1;
        this.servo2 = servo2;
    }

    public void moveToPickup() {
        servo1.setPosition(PICKUP_SERVO);
        servo2.setPosition(PICKUP_SERVO);
    }

    public void moveToDrop() {
        servo1.setPosition(DROP_SERVO);
        servo2.setPosition(DROP_SERVO);
    }

    public void moveToVertical() {
        servo1.setPosition(VERTICAL_SERVO);
        servo2.setPosition(VERTICAL_SERVO);
    }
}
