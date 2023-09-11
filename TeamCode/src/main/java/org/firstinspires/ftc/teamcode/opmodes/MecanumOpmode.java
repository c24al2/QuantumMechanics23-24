package org.firstinspires.ftc.teamcode.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.drive.MecanumDrive;
//import org.firstinspires.ftc.teamcode.mechanisms.MainClaw;
//import org.firstinspires.ftc.teamcode.mechanisms.Flipper;
//import org.firstinspires.ftc.teamcode.mechanisms.Lift;
import org.firstinspires.ftc.teamcode.mechanisms.Hopper;

@TeleOp(name = "MecanumDriveTeleOp", group = "TeleOp")
public class MecanumOpmode extends LinearOpMode {
    public static double DRIVER_SPEED_SCALAR = 0.85;
    public static double DRIVER_SPRINT_MODE_SCALAR = 0.85;
    public static double DRIVER_ROTATION_SCALAR = 0.5;
    public static double DRIVER_SLOW_MODE_SCALAR = 0.50;
    public static double SENSITIVITY_THRESHOLD = 0.20;

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;
//    private DcMotor airplane1;
//    private DcMotor airplane2;
    private DcMotor lift_motor;
//    private Servo mainClawServo;
//    private Servo servo1;
//    private Servo servo2;
//
//    private DcMotor liftMotor1;
//    private DcMotor liftMotor2;
//
    private Servo hopperServo;

    @Override
    public void runOpMode() {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
//        mainClawServo = hardwareMap.get(Servo.class, "m_claw_servo");
//        servo1 = hardwareMap.get(Servo.class, "flip_1");
//        servo2 = hardwareMap.get(Servo.class, "flip_2");
//        liftMotor1 = hardwareMap.get(DcMotor.class, "lift1");
//        liftMotor2 = hardwareMap.get(DcMotor.class, "lift2");
        hopperServo = hardwareMap.get(Servo.class, "hopper_servo");
//        airplane1 = hardwareMap.get(DcMotor.class, "air1");
//        airplane2 = hardwareMap.get(DcMotor.class, "air2");
        lift_motor = hardwareMap.get(DcMotor.class, "lift_motor");
        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        fr.setDirection(DcMotorSimple.Direction.FORWARD);
        br.setDirection(DcMotorSimple.Direction.FORWARD);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        airplane1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        airplane1.setDirection(DcMotorSimple.Direction.FORWARD);
//        airplane2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        airplane2.setDirection(DcMotorSimple.Direction.REVERSE);
        lift_motor.setDirection(DcMotorSimple.Direction.FORWARD);
        lift_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        MecanumDrive myDrive = new MecanumDrive(fl, fr, bl, br);
//        MainClaw claw = new MainClaw(mainClawServo);
//        Flipper flipper = new Flipper(servo1, servo2);
//        Lift lift = new Lift(liftMotor1, liftMotor2);
        Hopper hopper = new Hopper(hopperServo);
        telemetry.addData("Status: ", "Waiting for Start");
        telemetry.update();
            hopper.setPickupPosition();
        waitForStart();

        while (opModeIsActive()) {
            double x = gamepad1.left_stick_x;
            double y = -gamepad1.left_stick_y;
            double yaw = gamepad1.right_stick_x;

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

            myDrive.drive(x, y, yaw * DRIVER_ROTATION_SCALAR, scalar);

            //gunner controls
//            if (gamepad2.x) {
//                airplane1.setPower(1);
//                airplane2.setPower(1);
//            }
//            else {
//                airplane1.setPower(0);
//                airplane2.setPower(0);
//            }
            if (gamepad2.left_stick_y > 0.1){
                lift_motor.setPower(gamepad2.left_stick_y);
            }
            if (gamepad2.left_stick_y < -0.1){
                lift_motor.setPower(gamepad2.left_stick_y);
            }
            else {
                lift_motor.setPower(0);
            }
//            if (gamepad2.x) {
//                claw.open();
//            }
//            else if (gamepad2.dpad_up) {
//                claw.handoff();
//            }
//            else if (gamepad2.y) {
//                claw.close();
//            }
//
//            if (gamepad2.a) {
//                flipper.moveToPickup();
//            } else if (gamepad2.b) {
//                flipper.moveToDrop();
//            } else if (gamepad2.dpad_down) {
//                flipper.moveToVertical();
//            }
//
            if (gamepad2.b) {
                hopper.setPickupPosition();
            }
            else if (gamepad2.a) {
                hopper.setDropPosition();
            }
//
//            lift.update(gamepad2);

            telemetry.addData("Status: ", "Running");
            telemetry.update();
        }

    }

}
