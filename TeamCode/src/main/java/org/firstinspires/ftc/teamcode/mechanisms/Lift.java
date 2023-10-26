package org.firstinspires.ftc.teamcode.mechanisms;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Lift {
    public static double LIFT_THRESHOLD = 0.2;
    private DcMotor liftMotor;

    public Lift(DcMotor liftMotor) {
        this.liftMotor = liftMotor;
    }

    public void update(Gamepad gamepad) {
        if (Math.abs(gamepad.left_stick_y) < LIFT_THRESHOLD) {
            liftMotor.setPower(-gamepad.left_stick_y);
        }
        else{
            liftMotor.setPower(0);
        }
    }
}
