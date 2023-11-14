package org.firstinspires.ftc.teamcode.utilities;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Claw Tester", group = "TeleOp")
public class Claw_Tester extends LinearOpMode {
    private Servo leftServo;
    private Servo rightServo;

    @Override
    public void runOpMode() {
        leftServo = hardwareMap.get(Servo.class, "wristright");
        rightServo = hardwareMap.get(Servo.class, "wristleft");
        double position = 0.3;
        double increment = 0.05;

        waitForStart();

        while (opModeIsActive()) {
            // sweep
            leftServo.setPosition(position);
            rightServo.setPosition(position);

            telemetry.addData("Position", position);
            telemetry.update();
            sleep(3000);

            position += increment;

            if (position > 1.0) {
                break;
            }
        }
        rightServo.setPosition(0.5);
        leftServo.setPosition(0.5);

        telemetry.addData("Status", "Calibration Complete");
        telemetry.update();
        sleep(2000);
    }
}