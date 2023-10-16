package org.firstinspires.ftc.teamcode.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanisms.MainClaw;
import org.firstinspires.ftc.teamcode.mechanisms.Flipper;
import org.firstinspires.ftc.teamcode.mechanisms.Lift;
import org.firstinspires.ftc.teamcode.mechanisms.Hopper;

@TeleOp(name = "MecanumDriveTeleOp", group = "TeleOp")
public class MecanumOpmode extends LinearOpMode {
    public static double DRIVER_SPEED_SCALAR = 0.85;
    public static double DRIVER_SPRINT_MODE_SCALAR = 0.95;
    public static double DRIVER_ROTATION_SCALAR = 0.5;
    public static double DRIVER_SLOW_MODE_SCALAR = 0.50;
    public static double SENSITIVITY_THRESHOLD = 0.20;
    public static double LEFT_OPEN_POSITION = 0.7;
    public static double LEFT_CLOSE_POSITION = 0.62;
    public static double RIGHT_OPEN_POSITION = 0.75;
    public static double RIGHT_CLOSE_POSITION = 0.62;

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;
    private DcMotor extend;
    private Servo servoLeft;
    private Servo servoRight;

    @Override
    public void runOpMode() {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        extend = hardwareMap.get(DcMotor.class, "extend");

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);
        fr.setDirection(DcMotorSimple.Direction.FORWARD);
        br.setDirection(DcMotorSimple.Direction.FORWARD);
        extend.setDirection(DcMotorSimple.Direction.FORWARD);

        servoLeft = hardwareMap.get(Servo.class, "left_servo");
        servoRight = hardwareMap.get(Servo.class, "right_servo");

        servoLeft.setPosition(0.8);
        servoRight.setPosition(0.8);

        MecanumDrive myDrive = new MecanumDrive(fl, fr, bl, br);
        telemetry.addData("Status: ", "Waiting for Start");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            double x = gamepad1.left_stick_x;
            double y = -gamepad1.left_stick_y;
            double yaw = gamepad1.left_trigger;
            double negative_yaw = gamepad1.right_trigger;

            if (Math.abs(yaw) < SENSITIVITY_THRESHOLD) {
                yaw = 0;
            }

            if (Math.abs(x) < SENSITIVITY_THRESHOLD){
                x = 0;
            }
            if (Math.abs(y) < SENSITIVITY_THRESHOLD) {
                y = 0;
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

            myDrive.drive(x, y, yaw * DRIVER_ROTATION_SCALAR, scalar);

            telemetry.addData("Status: ", "Running");
            telemetry.update();

            if (Math.abs(gamepad2.left_stick_y) > SENSITIVITY_THRESHOLD){
                extend.setPower(-gamepad2.left_stick_y * .95);
                telemetry.addData("Status: ", "Extending");
                telemetry.update();
            }
            else {
                extend.setPower(0);
                telemetry.addData("Status: ", "NOT extending");
                telemetry.update();
            }

            if (gamepad2.a){
                //open the claw
                servoLeft.setPosition(LEFT_OPEN_POSITION);
                servoRight.setPosition(RIGHT_OPEN_POSITION);
            }
            else if (gamepad2.b) {
                //close the claw
                servoLeft.setPosition(LEFT_CLOSE_POSITION);
                servoRight.setPosition(RIGHT_CLOSE_POSITION);
            }


        }

    }

}
