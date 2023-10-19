package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Servo;
public class Wrist {

    private Servo wristServo1;
    private double defaultOpenPosition1;
    private double handoffPosition1;
    private Servo wristServo2;
    private double defaultOpenPosition2;
    private double handoffPosition2;
    public static final double DEFAULT2 = 0.0;
    public static final double HANDOFF2 = 1.0;
    public static final double DEFAULT1 = 0.0;
    public static final double HANDOFF1 = 1.0;

    public Wrist(Servo servo1, Servo servo2) {
        this.wristServo1 = servo1;
        this.wristServo2 = servo2;
        this.defaultOpenPosition1 = DEFAULT1;
        this.defaultOpenPosition2 = DEFAULT2;
        this.handoffPosition1 = HANDOFF1;
        this.handoffPosition2 = HANDOFF2;
    }

    public void open() {
        wristServo1.setPosition(defaultOpenPosition1);
        wristServo2.setPosition(defaultOpenPosition2);
    }

    public void handoff() {
        wristServo1.setPosition(handoffPosition1);
        wristServo2.setPosition(handoffPosition2);
    }

}

