package org.firstinspires.ftc.teamcode.utilities;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Claw Position Finder", group = "TeleOp")
public class FrontClawPositions extends LinearOpMode {
    private Servo clawleft;
    private Servo clawright;

    @Override
    public void runOpMode() {
        clawleft = hardwareMap.get(Servo.class, "clawleft");
        clawright = hardwareMap.get(Servo.class, "clawright");
        double position = 0.3;
        double increment = 0.05;

        waitForStart();

        while (opModeIsActive()) {
            // sweep
            clawleft.setPosition(position);
            clawright.setPosition(position);

            telemetry.addData("Position", position);
            telemetry.update();
            sleep(3000);

            position += increment;

            if (position > 1.0) {
                break;
            }
        }
        clawleft.setPosition(0.5);
        clawright.setPosition(0.5);

        telemetry.addData("Status", "Calibration Complete");
        telemetry.update();
        sleep(2000);
    }
}