package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Servo;
public class Wrist {
    private Servo wrist;
    private final double flat;
    private final double three_stack;
    private final double five_stack;
    private final double full_flip;
    public static final double FLAT = 0.4;
    public static final double THREE_STACK_OFFSET = 0.2;
    public static final double FIVE_STACK_OFFSET = 0.6;
    public static final double FULL_FLIP = 0.5;

    public Wrist(Servo wrist) {
        this.wrist = wrist;
        this.flat = FLAT;
        this.three_stack = THREE_STACK_OFFSET;
        this.five_stack = FIVE_STACK_OFFSET;
        this.full_flip = FULL_FLIP;
    }

    public void flat_position() {
        wrist.setPosition(flat);
    }

    public void three_level() {
        wrist.setPosition(three_stack);
    }
    public void five_level() {
        wrist.setPosition(five_stack);
    }
    public void full_flip_level() {
        wrist.setPosition(full_flip);
    }

}

