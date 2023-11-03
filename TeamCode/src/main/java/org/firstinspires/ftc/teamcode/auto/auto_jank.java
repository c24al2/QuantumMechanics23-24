package org.firstinspires.ftc.teamcode.auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanisms.Extend;
import org.firstinspires.ftc.teamcode.mechanisms.Flipper;
import org.firstinspires.ftc.teamcode.mechanisms.Hopper;
import org.firstinspires.ftc.teamcode.mechanisms.Lift;
import org.firstinspires.ftc.teamcode.mechanisms.MainClaw;
import org.firstinspires.ftc.teamcode.mechanisms.Pincher;
import org.firstinspires.ftc.teamcode.mechanisms.PincherWrist;
import org.firstinspires.ftc.teamcode.mechanisms.Wrist;

@Autonomous(name = "jank", group = "Auto")
public class auto_jank extends LinearOpMode {
    public static double DRIVER_SPEED_SCALAR = 0.85;
    public static double DRIVER_SPRINT_MODE_SCALAR = 0.95;
    public static double DRIVER_ROTATION_SCALAR = 0.5;
    public static double DRIVER_SLOW_MODE_SCALAR = 0.50;
    public static double SENSITIVITY_THRESHOLD = 0.20;
    public static ElapsedTime myTime = new ElapsedTime();

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;
    private DcMotor extend;
    private DcMotor lift;
    private Servo top_servo;
    private Servo bottom_servo;
    private Servo pincher;
    private Servo hopper;
    private Servo pincher_wrist;
    private Servo zOffset;

    @Override
    public void runOpMode() {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        extend = hardwareMap.get(DcMotor.class, "extend");
        lift = hardwareMap.get(DcMotor.class, "lift");

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

        top_servo = hardwareMap.get(Servo.class, "left_servo");
        bottom_servo = hardwareMap.get(Servo.class, "right_servo");
//        pincher = hardwareMap.get(Servo.class, "pincher");
//        hopper = hardwareMap.get(Servo.class, "hopper");
//        pincher_wrist = hardwareMap.get(Servo.class, "pincher_wrist");
//        zOffset = hardwareMap.get(Servo.class, "zOffset");

        MecanumDrive myDrive = new MecanumDrive(fl, fr, bl, br);
//        Extend myExtend = new Extend(extend);
////        Hopper myHopper = new Hopper(hopper);
//        Extend myExtend = new Extend(extend);
////        Hopper myHopper = new Hopper(hopper);
//        Lift myLift = new Lift(lift);
        MainClaw myMainClaw = new MainClaw(top_servo, bottom_servo);
//        Pincher myPincher = new Pincher(pincher);
//        PincherWrist myPincherWrist = new PincherWrist(pincher_wrist);
//        Wrist myWrist = new Wrist(zOffset);

        telemetry.addData("Status: ", "Waiting for Start");
        telemetry.update();
        waitForStart();
        myTime.reset();
        while (opModeIsActive()) {

            while (myTime.milliseconds() < 4000) {
                fl.setPower(-0.25);
                fr.setPower(-0.25);
                bl.setPower(-0.25);
                br.setPower(-0.25);

            }

        }

    }
}
























































