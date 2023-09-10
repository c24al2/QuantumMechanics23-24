package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Servo;

public class MainClaw {

    private Servo clawServo;
    private double defaultOpenPosition;
    private double closedPosition;
    private double handoffPosition;

    public static final double DEFAULT_OPEN = 0.5;
    public static final double CLOSED = 0.0;
    public static final double HANDOFF = 1.0;

    public MainClaw(Servo servo) {
        this.clawServo = servo;
        this.defaultOpenPosition = DEFAULT_OPEN;
        this.closedPosition = CLOSED;
        this.handoffPosition = HANDOFF;
    }

    public void open() {
        clawServo.setPosition(defaultOpenPosition);
    }

    public void close() {
        clawServo.setPosition(closedPosition);
    }

    public void handoff() {
        clawServo.setPosition(handoffPosition);
    }
}
