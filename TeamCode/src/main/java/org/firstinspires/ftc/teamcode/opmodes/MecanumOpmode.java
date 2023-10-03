package org.firstinspires.ftc.teamcode.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanisms.MainClaw;
import org.firstinspires.ftc.teamcode.mechanisms.Flipper;
import org.firstinspires.ftc.teamcode.mechanisms.Lift;
import org.firstinspires.ftc.teamcode.mechanisms.Hopper;

@TeleOp(name = "MecanumDriveTeleOp", group = "TeleOp")
public class MecanumOpmode extends LinearOpMode {
    public static double DRIVER_SPEED_SCALAR = 0.7;
    public static double DRIVER_SPRINT_MODE_SCALAR = 0.85;
    public static double DRIVER_ROTATION_SCALAR = 0.5;
    public static double DRIVER_SLOW_MODE_SCALAR = 0.50;
    public static double SENSITIVITY_THRESHOLD = 0.20;

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;

    @Override
    public void runOpMode() {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");

        MecanumDrive myDrive = new MecanumDrive(fl, fr, bl, br);
        telemetry.addData("Status: ", "Waiting for Start");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            double x = gamepad1.left_stick_x;
            double y = -gamepad1.left_stick_y;
            double yaw = gamepad1.left_trigger;

            if (Math.abs(x) < SENSITIVITY_THRESHOLD){
                x = 0;
            }
            if (Math.abs(y) < SENSITIVITY_THRESHOLD){
                y = 0;
            }
            if (Math.abs(yaw) < SENSITIVITY_THRESHOLD){
                yaw = 0;
            }

            double scalar = DRIVER_SPEED_SCALAR;
            //button a activates slow mode
            if (gamepad1.a){
                scalar = DRIVER_SLOW_MODE_SCALAR;
            }
            //button b activates sprint mode
            else if (gamepad1.b){
                scalar = DRIVER_SPRINT_MODE_SCALAR;
            }

            myDrive.drive(x, y, yaw/DRIVER_ROTATION_SCALAR, scalar);

            telemetry.addData("Status: ", "Running");
            telemetry.update();
        }

    }

}
