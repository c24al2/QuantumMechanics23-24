package org.firstinspires.ftc.teamcode.utilities;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "ServoSyncTeleOp", group = "TeleOp")
public class ArmServoSyncer extends LinearOpMode {

    private Servo servoLeft;
    private Servo servoRight;

    public void runOpMode() {
        servoLeft = hardwareMap.get(Servo.class, "left_servo");
        servoRight = hardwareMap.get(Servo.class, "right_servo");

        waitForStart();
        ServoSync servoSync = new ServoSync(servoLeft, servoRight);

        while (opModeIsActive()) {

            //double desiredPosition = gamepad2.left_stick_y;
            double desiredPosition = 0.2;
            servoSync.syncServos(desiredPosition);
            telemetry.addData("Status: ", "Synced!");
            telemetry.update();

        }
    }

    class ServoSync {

        private Servo servo1;
        private Servo servo2;

        public ServoSync(Servo servo1, Servo servo2) {
            this.servo1 = servo1;
            this.servo2 = servo2;
        }

        public void syncServos(double position) {
            servo1.setPosition(position);
            servo2.setPosition(position);
        }
    }
}
