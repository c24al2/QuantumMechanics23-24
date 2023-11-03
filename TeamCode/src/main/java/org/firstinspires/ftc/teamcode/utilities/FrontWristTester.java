package org.firstinspires.ftc.teamcode.utilities;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Front Wrist Sync", group = "TeleOp")
public class FrontWristTester extends LinearOpMode {
    private Servo wristleft;
    private Servo wristright;

    @Override
    public void runOpMode() {
        wristleft = hardwareMap.get(Servo.class, "wristleft");
        wristright = hardwareMap.get(Servo.class, "wristright");

        while (opModeIsActive()) {
            // sweep
            wristleft.setPosition(0.5);
            wristright.setPosition(0.5);

            telemetry.addData("Position", "0.5");
            telemetry.update();
            sleep(3000);

        }
        telemetry.addData("Status", "Calibration Complete");
        telemetry.update();
        sleep(2000);
    }
}