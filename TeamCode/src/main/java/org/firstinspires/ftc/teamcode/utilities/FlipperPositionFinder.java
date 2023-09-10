package org.firstinspires.ftc.teamcode.utilities;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.mechanisms.Flipper;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Flipper_Position_Sweep", group = "TeleOp")
public class FlipperPositionFinder extends LinearOpMode {

    private Servo servo1;
    private Servo servo2;

    @Override
    public void runOpMode() {
        servo1 = hardwareMap.get(Servo.class, "flip_1");
        servo2 = hardwareMap.get(Servo.class, "flip_2");

        Flipper flipper = new Flipper(servo1, servo2);

        double position1 = 0.0;
        double position2 = 0.0;
        double increment = 0.05;

        waitForStart();

        while (opModeIsActive()) {
            //sweep
            servo1.setPosition(position1);
            servo2.setPosition(position2);

            telemetry.addData("Servo 1", position1);
            telemetry.addData("Servo 2", position2);
            telemetry.update();

            sleep(1000);

            position1 += increment;
            position2 += increment;

            if (position1 > 1.0) {
                break;
            }
        }
        telemetry.addData("Status", "Sweep Complete");
        telemetry.update();
        sleep(2000);
    }
}
