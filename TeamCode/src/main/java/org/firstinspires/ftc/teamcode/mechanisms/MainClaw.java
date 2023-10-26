package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Servo;

public class MainClaw {

    private Servo clawServo1;
    private Servo clawServo2;
    private double top_open;
    private double top_closed;
    private double bottom_open;
    private double bottom_closed;

    public static final double TOP_OPEN = 0.5;
    public static final double TOP_CLOSED = 0.0;
    public static final double BOTTOM_OPEN = 1.0;
    public static final double BOTTOM_CLOSED = 1.0;

    public MainClaw(Servo top_servo, Servo bottom_servo) {
        this.clawServo1 = top_servo;
        this.clawServo2 = bottom_servo;
        this.bottom_open = BOTTOM_OPEN;
        this.bottom_closed = BOTTOM_CLOSED;
        this.top_open = TOP_OPEN;
        this.top_closed = TOP_CLOSED;
    }

    public void open_both() {
        clawServo1.setPosition(bottom_open);
        clawServo2.setPosition(top_open);
    }

    public void droptop() {
        clawServo1.setPosition(bottom_closed);
        clawServo2.setPosition(top_open);
    }
    public void dropbottom() {
        clawServo1.setPosition(bottom_open);
        clawServo2.setPosition(top_open);
    }
    public void pickup() {
        clawServo1.setPosition(bottom_closed);
        clawServo2.setPosition(top_closed);
    }
}
