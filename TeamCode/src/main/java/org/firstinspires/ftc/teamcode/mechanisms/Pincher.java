package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Servo;

public class Pincher {
    private Servo pincher;

    public static final double PINCHER_PICKUP = 0.0;
    public static final double PINCHER_DEPOSIT = 0.5;

    public Pincher(Servo pincher) {
        this.pincher = pincher;
    }

    public void Pickup_Pincher() {
        pincher.setPosition(PINCHER_PICKUP);
    }

    public void Deposit_Pincher() {
        pincher.setPosition(PINCHER_DEPOSIT);
    }
}