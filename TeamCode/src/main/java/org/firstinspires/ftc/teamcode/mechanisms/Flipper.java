package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Servo;

public class Flipper {
    private Servo zOffset;

    public static final double FLAT = 0.0;
    public static final double FIVE_STACK = 0.5;
    public static final double THREE_STACK = 1.0;

    public Flipper(Servo zOffset) {
        this.zOffset = zOffset;
    }

    public void Standard_Pickup() {
        zOffset.setPosition(FLAT);
    }

    public void Three_Stack() {
        zOffset.setPosition(THREE_STACK);
    }

    public void Five_Stack_and_Drop() {
        zOffset.setPosition(FIVE_STACK);
    }
}
