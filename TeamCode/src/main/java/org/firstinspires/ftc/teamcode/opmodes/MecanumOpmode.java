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

@TeleOp(name = "MecanumDriveTeleOp", group = "TeleOp")
public class MecanumOpmode extends LinearOpMode {
    public static double DRIVER_SPEED_SCALAR = 0.85;
    public static double DRIVER_SPRINT_MODE_SCALAR = 0.95;
    public static double DRIVER_ROTATION_SCALAR = 0.5;
    public static double DRIVER_SLOW_MODE_SCALAR = 0.50;
    public static double SENSITIVITY_THRESHOLD = 0.20;

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;
//    private DcMotor extend;
//    private DcMotor lift;
//    private Servo top_servo;
//    private Servo bottom_servo;
//    private Servo pincher;


    @Override
    public void runOpMode() {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
//        extend = hardwareMap.get(DcMotor.class, "extend");
//        lift = hardwareMap.get(DcMotor.class, "lift");
//        pincher = hardwareMap.get(Servo.class, "pincher");

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        extend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);
        fr.setDirection(DcMotorSimple.Direction.FORWARD);
        br.setDirection(DcMotorSimple.Direction.FORWARD);
//        extend.setDirection(DcMotorSimple.Direction.FORWARD);
//
//        top_servo = hardwareMap.get(Servo.class, "left_servo");
//        bottom_servo = hardwareMap.get(Servo.class, "right_servo");
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
//        MainClaw myMainClaw = new MainClaw(top_servo, bottom_servo);
//        Pincher myPincher = new Pincher(pincher);
//        PincherWrist myPincherWrist = new PincherWrist(pincher_wrist);
//        Wrist myWrist = new Wrist(zOffset);

        telemetry.addData("Status: ", "Waiting for Start");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            double x = gamepad1.left_stick_x;
            double y = -gamepad1.left_stick_y;
            double yaw = gamepad1.right_stick_x;

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
//                extend.setPower(-gamepad2.left_stick_y * .95);
                telemetry.addData("Status: ", "Extending");
                telemetry.update();
            }
            else {
//                extend.setPower(0);
                telemetry.addData("Status: ", "NOT extending");
                telemetry.update();
            }
            if (Math.abs(gamepad2.right_stick_y) > SENSITIVITY_THRESHOLD){
//                lift.setPower(-gamepad2.right_stick_y * .95);
                telemetry.addData("Status: ", "Extending");
                telemetry.update();
            }
            else {
//                lift.setPower(0);
                telemetry.addData("Status: ", "NOT extending");
                telemetry.update();
            }

            //gunner controls begin here
            //claw controls
//            if (gamepad2.a){
//                myMainClaw.open_both();
//            }
//            if (gamepad2.b) {
//                pincher.setPosition(1);
//            }
//            else if (gamepad2.y){
//                myMainClaw.dropbottom();
//            }
//            //pincher
//            if (gamepad2.left_trigger < SENSITIVITY_THRESHOLD){
//                myPincher.Pickup_Pincher();
//            }
//            else if (gamepad2.right_trigger < SENSITIVITY_THRESHOLD){
//                myPincher.Deposit_Pincher();
//            }
//            //wrist offsets
//            if (gamepad2.dpad_up){
//                myWrist.full_flip_level();
//            }
//            else if (gamepad2.dpad_down){
//                myWrist.flat_position();
//            }
//            else if (gamepad2.dpad_left){
//                myWrist.three_level();
//            }
//            else if (gamepad2.dpad_right){
//                myWrist.five_level();
//            }
//            //pincher wrist offsets
//            if (gamepad2.left_bumper){
//                myPincherWrist.Pickup();
//            }
//            else if (gamepad2.right_bumper){
//                myPincherWrist.Deposit();
//            }
//
//            myLift.update(gamepad2);
//            myExtend.update(gamepad2);
//



        }

    }

}
