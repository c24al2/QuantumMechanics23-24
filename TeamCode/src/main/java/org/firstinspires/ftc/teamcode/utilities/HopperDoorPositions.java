package org.firstinspires.ftc.teamcode.utilities;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Hopper Position Finder", group = "TeleOp")
public class HopperDoorPositions extends LinearOpMode {
    private Servo hopper;

    @Override
    public void runOpMode() {
        hopper = hardwareMap.get(Servo.class, "hopper");
        double position = 0.05;
        double increment = 0.03;
        hopper.setPosition(0.05);

        waitForStart();

        while (opModeIsActive()) {
            // sweep
            hopper.setPosition(position);

            telemetry.addData("Position", position);
            telemetry.update();
            sleep(3000);

            position += increment;

            if (position > 1.0) {
                break;
            }
        }
        hopper.setPosition(0.5);

        telemetry.addData("Status", "Calibration Complete");
        telemetry.update();
        sleep(2000);
    }
}