package org.firstinspires.ftc.teamcode.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanisms.Extend;
import org.firstinspires.ftc.teamcode.mechanisms.Flipper;
import org.firstinspires.ftc.teamcode.mechanisms.Hopper;
import org.firstinspires.ftc.teamcode.mechanisms.Lift;
import org.firstinspires.ftc.teamcode.mechanisms.MainClaw;
import org.firstinspires.ftc.teamcode.mechanisms.Pincher;
import org.firstinspires.ftc.teamcode.mechanisms.PincherWrist;
import org.firstinspires.ftc.teamcode.mechanisms.Wrist;

@TeleOp(name = "V3MecanumDriveTeleOp", group = "TeleOp")
public class V3MecanumOpmode extends LinearOpMode {
    public static double DRIVER_SPEED_SCALAR = 0.85;
    public static double DRIVER_SPRINT_MODE_SCALAR = 0.95;
    public static double DRIVER_ROTATION_SCALAR = 0.5;
    public static double DRIVER_SLOW_MODE_SCALAR = 0.50;
    public static double SENSITIVITY_THRESHOLD = 0.20;
    public static double LIFT_SCALAR = 0.85;

    private Servo wristleft;
    private Servo wristright;
    private Servo claw;
    private Servo hopper;
    private Servo launcher;

    //drive motors
    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;
    private DcMotor lift;

    private double intakeTimer;

    @Override
    public void runOpMode() {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        lift = hardwareMap.get(DcMotor.class, "lift");

        wristleft = hardwareMap.get(Servo.class, "wristleft");
        wristright = hardwareMap.get(Servo.class, "wristright");
        claw = hardwareMap.get(Servo.class, "claw");
        hopper = hardwareMap.get(Servo.class, "hopper");
        launcher = hardwareMap.get(Servo.class, "launcher");

        //tighten the launcher
        launcher.setPosition(0.6);
        hopper.setPosition(0.38);
        waitForStart();

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);
        fr.setDirection(DcMotorSimple.Direction.FORWARD);
        br.setDirection(DcMotorSimple.Direction.FORWARD);
        lift.setDirection(DcMotorSimple.Direction.FORWARD);

        MecanumDrive myDrive = new MecanumDrive(fl, fr, bl, br);
        telemetry.addData("Status: ", "Waiting for Start");
        telemetry.update();
        double yaw = 0;
        intakeTimer = System.currentTimeMillis();

        while (opModeIsActive()) {
            double currentTime = System.currentTimeMillis();
            double elapsedIntakeTimer = currentTime - intakeTimer;
            telemetry.addData("Status: ", "Running!");
            double x = gamepad1.left_stick_x;
            double y = -gamepad1.left_stick_y;
            yaw = gamepad1.left_trigger - gamepad1.right_trigger;

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
            if (gamepad1.a){
                scalar = DRIVER_SLOW_MODE_SCALAR;
            }
            //button b activates sprint mode
            else if (gamepad1.b){
                scalar = DRIVER_SPRINT_MODE_SCALAR;
            }

            myDrive.drive(x, y, yaw * DRIVER_ROTATION_SCALAR, scalar);

            //gunner controls
            //open claw
            if (gamepad2.a){
                claw.setPosition(0.32);
            }
            //close claw
            else if (gamepad2.b){
                claw.setPosition(0.49);
            }
            //wrist ground
            if (gamepad2.x){
               wristleft.setPosition(0.03);
               wristright.setPosition(0.97);
            }
            //wrist flip
            else if (gamepad2.y){
                wristleft.setPosition(0.68);
                wristright.setPosition(.32);
            }
            //pickup + drop into hopper
            if (gamepad2.dpad_up){
                //close claw
                if (elapsedIntakeTimer < 500) {
                    claw.setPosition(0.49);
                }
                //flip
                else if (elapsedIntakeTimer < 800) {
                    wristleft.setPosition(0.68);
                    wristright.setPosition(.32);
                }
                //open claw
                else if (elapsedIntakeTimer < 1100) {
                    claw.setPosition(0.32);
                }
                //reset
                if (elapsedIntakeTimer >= 1100) {
                    intakeTimer = currentTime;

                }
            }
            //test together funcs
            if (gamepad2.dpad_down){
                claw.setPosition(0.49);
                wristleft.setPosition(0.68);
                wristright.setPosition(.32);
                claw.setPosition(0.32);
            }

            if (gamepad2.left_trigger > 0.5){
                launcher.setPosition(0.4);
            }

            //close hopper
            if (gamepad2.left_bumper){
                hopper.setPosition(0.38);
            }
            //open hopper
            else if (gamepad2.right_bumper){
                hopper.setPosition(0.05);
            }

            if (Math.abs(gamepad2.right_stick_y) > SENSITIVITY_THRESHOLD){
                double power = -gamepad2.right_stick_y;
                lift.setPower(power * LIFT_SCALAR);
            }
            else{
                lift.setPower(0);
            }
        }

    }

}
