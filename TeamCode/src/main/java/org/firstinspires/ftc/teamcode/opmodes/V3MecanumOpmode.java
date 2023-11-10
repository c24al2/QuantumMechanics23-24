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

    private Servo wristleft;
    private Servo wristright;
    private Servo claw;
    private Servo launcher;



    @Override
    public void runOpMode() {

        wristleft = hardwareMap.get(Servo.class, "wristleft");
        wristright = hardwareMap.get(Servo.class, "wristright");
        claw = hardwareMap.get(Servo.class, "claw");
        launcher = hardwareMap.get(Servo.class, "launcher");

        telemetry.addData("Status: ", "Waiting for Start");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            //open claw
            if (gamepad1.x){
                claw.setPosition(0.38);
            }
            //close claw
            else if (gamepad1.y){
                claw.setPosition(0.48);
            }
            //open claw top
            if (gamepad2.x){
                wristleft.setPosition(0.47);
            }
            //close claw bottom
            else if (gamepad2.y){
                wristleft.setPosition(0.37);
            }
            //open claw top
            if (gamepad2.a){
                wristright.setPosition(0.6);
            }
            //close claw top
            else if (gamepad2.b){
                wristright.setPosition(0.4);
            }
            if (gamepad2.left_trigger >= 0.5){
                launcher.setPosition(0.4);
            }
            else if (gamepad2.right_trigger >= 0.5){
                launcher.setPosition(0.6);
            }
        }

    }

}
