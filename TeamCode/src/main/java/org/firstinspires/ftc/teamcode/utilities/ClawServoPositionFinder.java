package org.firstinspires.ftc.teamcode.utilities;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Claw Position Finder", group = "TeleOp")
public class ClawServoPositionFinder extends LinearOpMode {
    private Servo clawServo;

    @Override
    public void runOpMode() {
        clawServo = hardwareMap.get(Servo.class, "m_claw_servo");
        double position = 0.0;
        double increment = 0.05;

        waitForStart();

        while (opModeIsActive()) {
            // sweep
            clawServo.setPosition(position);

            telemetry.addData("Position", position);
            telemetry.update();
            sleep(1000);

            position += increment;

            if (position > 1.0) {
                break;
            }
        }
        clawServo.setPosition(0.5);

        telemetry.addData("Status", "Calibration Complete");
        telemetry.update();
        sleep(2000);
    }
}
