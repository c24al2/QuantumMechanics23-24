package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Servo;

public class PincherWrist {
    private Servo pincherWrist;

    public static final double PICKUP = 0.0;
    public static final double DEPOSIT = 0.5;
    public static final double INTERMEDIATE = 1.0;

    public PincherWrist(Servo pincherWrist) {
        this.pincherWrist = pincherWrist;
    }

    public void Pickup() {
        pincherWrist.setPosition(PICKUP);
    }

    public void Intermediate() {
        pincherWrist.setPosition(INTERMEDIATE);
    }

    public void Deposit() {
        pincherWrist.setPosition(DEPOSIT);
    }
}
