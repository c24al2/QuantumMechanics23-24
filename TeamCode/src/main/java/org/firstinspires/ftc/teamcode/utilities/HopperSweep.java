package org.firstinspires.ftc.teamcode.utilities;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Hopper PositionFinder", group = "TeleOp")
public class HopperSweep extends LinearOpMode {
    private Servo hopperServo;

    @Override
    public void runOpMode() {
        hopperServo = hardwareMap.get(Servo.class, "hopper_servo");
        double position = 0.0;
        double increment = 0.05;

        waitForStart();

        while (opModeIsActive()) {
            // sweep
            hopperServo.setPosition(position);

            telemetry.addData("Position", position);
            telemetry.update();
            sleep(1000);

            position += increment;

            if (position > 1.0) {
                break;
            }
        }
        hopperServo.setPosition(0.5);

        telemetry.addData("Status", "Calibration Complete");
        telemetry.update();
        sleep(2000);
    }
}
