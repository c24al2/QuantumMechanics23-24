package org.firstinspires.ftc.teamcode.mechanisms;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Extend {
    public static double EXTEND_THRESHOLD = 0.2;
    private DcMotor extend;

    public Extend(DcMotor extend) {
        this.extend = extend;
    }

    public void update(Gamepad gamepad) {
        if (Math.abs(gamepad.left_stick_y) < EXTEND_THRESHOLD) {
            extend.setPower(-gamepad.left_stick_y);
        }
        else{
            extend.setPower(0);
        }
    }
}
