package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


//@TeleOp(name="Pushbot: Team9788 Pushbot Teleop2", group="Pushbot")
//@Disabled
public class Team9788PushbotTeleOp2 extends OpMode {

    Team9788HardwarePushbot robot = new Team9788HardwarePushbot();


    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);




        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }
    double left;
    double right;
    //    double whiteMotor;
    double yellowValue;
    double greenMotor;
    double blueMotor;
//    double redMotor;

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {



        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        right = -gamepad1.left_stick_y;
        left = -gamepad1.right_stick_y;
        yellowValue = gamepad2.right_trigger - gamepad2.left_trigger;




        //yellowMotor = -gamepad2.right_stick_y;
        // whiteMotor = gamepad2.right_stick_y;

        robot.leftDrive.setPower(left);
        robot.rightDrive.setPower(right);
        // robot.white.setPower(whiteMotor);//changed**
        robot.yellow.setPower(yellowValue);//changed***
//        robot.green.setPower(greenMotor);
//        robot.blue.setPower(blueMotor);
//        robot.red.setPower(redMotor);
        //robot.yellow.setPower(yellowMotor);
//        robot.white.setPower(1);


        //Continous Servo...
        if(gamepad2.left_bumper){
            robot.clawServo.setPosition(1);
        }
        else{
            robot.clawServo.setPosition(0);
        }



//
//        if(gamepad2.a){
//            robot.yellow.setPower(1);
//            //robot.yellow.setTargetPosition(robot.yellow.getCurrentPosition()+50);
//            //robot.white.setTargetPosition(robot.white.getCurrentPosition()+50);
//        }
//        else if(gamepad2.y){
//            robot.yellow.setPower(-1);
//            //robot.yellow.setTargetPosition(robot.yellow.getCurrentPosition()-50);
//            //robot.white.setTargetPosition(robot.white.getCurrentPosition()-50);
//        }
//        else{
//            robot.yellow.setPower(0);
//            //robot.yellow.setPower(-0.5);
//            //robot.white.setPower(0.5);
//            robot.yellow.setTargetPosition(robot.yellow.getCurrentPosition());
//            //robot.white.setTargetPosition(robot.white.getCurrentPosition());
//        }



        // Use gamepad buttons to move the arm up (Y) and down (A)
//        if (gamepad2.y)
//
//        else if (gamepad2.a)
//            robot.white.setPower(-0.01);
//        else
//            robot.white.setPower(0);


        // Use gamepad buttons to move the arm up (Y) and down (A)
        if (gamepad1.dpad_up) {
            robot.green.setPower(1);
        }
        else if (gamepad1.dpad_down) {
            robot.green.setPower(-1);
        }
        else {
            robot.green.setPower(0);
        }



        if (gamepad2.y) {
            robot.blue.setPower(-1);
        }
        else if (gamepad2.a) {
            robot.blue.setPower(1);
        }
        else {
            robot.blue.setPower(0);
        }

/*
        if (gamepad2.dpad_left) {
            robot.red.setPower(1);
        }
        else if (gamepad2.dpad_right) {
            robot.red.setPower(-1);
        }
        else {
            robot.red.setPower(0);
        }
*/




        // Send telemetry message to signify robot running;
        //telemetry.addData("claw",  "Offset = %.2f", clawOffset);
        telemetry.addData("left",  "%.2f", left);
        telemetry.addData("right", "%.2f", right);
//        telemetry.addData("Blue",   "%.2f", blueMotor);
        telemetry.addData("Yellow",   "%.2f", yellowValue);
//        telemetry.addData("Green",   "%.2f", greenMotor);

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }


}
