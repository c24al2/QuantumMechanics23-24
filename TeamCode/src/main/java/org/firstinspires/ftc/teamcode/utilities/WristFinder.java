package org.firstinspires.ftc.teamcode.utilities;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Claw Position Finder", group = "TeleOp")
public class WristFinder extends LinearOpMode {
    private Servo wristleft;
    private Servo wristright;

    @Override
    public void runOpMode() {
        wristleft = hardwareMap.get(Servo.class, "wristleft");
        wristright = hardwareMap.get(Servo.class, "wristright");
        double position = 0.3;
        double increment = 0.05;

        waitForStart();

        while (opModeIsActive()) {
            // sweep
            wristleft.setPosition(position);
            wristright.setPosition(position);

            telemetry.addData("Position", position);
            telemetry.update();
            sleep(3000);

            position += increment;

            if (position > 1.0) {
                break;
            }
        }
        wristleft.setPosition(0.5);
        wristright.setPosition(0.5);

        telemetry.addData("Status", "Calibration Complete");
        telemetry.update();
        sleep(2000);
    }
}