package org.firstinspires.ftc.teamcode.mechanisms;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Lift {
    public static double LIFT_THRESHOLD = 0.2;
    private DcMotor liftMotor1;
    private DcMotor liftMotor2;
    private int targetEncoderCount;

    public Lift(DcMotor liftMotor1, DcMotor liftMotor2) {
        this.liftMotor1 = liftMotor1;
        this.liftMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.liftMotor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.liftMotor2 = liftMotor2;
        this.liftMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.liftMotor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.targetEncoderCount = 0;
    }

    public void update(Gamepad gamepad) {
        if (Math.abs(gamepad.left_stick_y) < LIFT_THRESHOLD) {
            targetEncoderCount += 5 * -gamepad.left_stick_y;
        } else if (Math.abs(gamepad.left_stick_y) < LIFT_THRESHOLD) {
            targetEncoderCount -= 5 * -gamepad.left_stick_y;
        }

        liftMotor1.setTargetPosition(targetEncoderCount);
        liftMotor2.setTargetPosition(targetEncoderCount);
        liftMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor1.setPower(0.8);
        liftMotor2.setPower(0.8);
    }
}
