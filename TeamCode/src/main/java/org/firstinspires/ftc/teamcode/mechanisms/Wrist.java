package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Servo;
public class Wrist {

    private Servo wristServo1;
    private double defaultOpenPosition;
    private double closedPosition;
    private double handoffPosition;

    public static final double DEFAULT = 0.0;
    public static final double HANDOFF = 1.0;

    public Wrist(Servo servo) {
        this.wristServo1 = servo;
        this.defaultOpenPosition = DEFAULT;
        this.handoffPosition = HANDOFF;
    }

    public void open() {
        wristServo1.setPosition(defaultOpenPosition);
    }

    public void handoff() {
        wristServo1.setPosition(handoffPosition);
    }

}
