package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Pushbot: Team8648 Pushbot Teleop", group="Pushbot")
//@Disabled
public class Team8648PushbotTeleOp extends OpMode {

    Team8648HardwarePushbot robot = new Team8648HardwarePushbot();
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;
    double          clawOffset  = 0.0 ;                  // Servo mid position
    final double    CLAW_SPEED  = 0.02 ;



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

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double left;
        double right;
        double armMotor;
        double armRaiseMotor;
        double armRaiseMotor2;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;

        //armRaiseMotor = gamepad2.left_stick_y;
        //armRaiseMotor2 = gamepad2.left_stick_y;


        // Use gamepad buttons to move the arm up (Y) and down (A)
        if (gamepad2.y)
            robot.armRaise.setPower(0.75);
        else if (gamepad2.a)
            robot.armRaise2.setPower(-0.75);
        else
            robot.armRaise2.setPower(1);
        robot.armRaise2.setTargetPosition(robot.armRaise2.getCurrentPosition());



        //arm
        //armMotor = -gamepad2.right_stick_y;
        //armRaiseMotor = -gamepad2.left_stick_y;
        //armRaiseMotor2 = -gamepad2.left_stick_y;


        if (gamepad2.right_bumper)
            robot.arm.setPower(ARM_UP_POWER);
        else if (gamepad2.left_bumper)
            robot.arm.setPower(ARM_DOWN_POWER);
        else
            robot.arm.setPower(0.0);

        if(gamepad2.dpad_up)
            robot.armRaise.setPower(ARM_UP_POWER);
        else if(gamepad2.dpad_down)
            robot.armRaise.setPower(ARM_DOWN_POWER);
        else
            robot.armRaise.setPower(0.0);




        robot.leftDrive.setPower(left);
        robot.rightDrive.setPower(right);
        //robot.arm.setPower(armMotor);//changed**
        //robot.armRaise.setPower(armRaiseMotor);//changed***



        // Use gamepad buttons to move the arm up (Y) and down (A)



        if (gamepad1.right_bumper)
            robot.lift.setPower(1);
            //robot.lift.getCurrentPosition();
        else if (gamepad1.left_bumper)
            robot.lift.setPower(-1);
            //robot.lift.getCurrentPosition();
        else
            robot.lift.setPower(1);
            robot.lift.setTargetPosition(robot.lift.getCurrentPosition());


        if (gamepad2.x)
            clawOffset += CLAW_SPEED;
        else if (gamepad2.b)
            clawOffset -= CLAW_SPEED;

        // Move both servos to new position.  Assume servos are mirror image of each other.
        clawOffset = Range.clip(clawOffset, -0.5, 0.5);
        robot.leftClaw.setPosition(robot.MID_SERVO + clawOffset);
        robot.rightClaw.setPosition(robot.MID_SERVO - clawOffset);


        //Continous Servo...
//        if(gamepad2.a)
//            robot.armServo.setPosition(1);
//        else if (gamepad2.y)
//            robot.armServo.setPosition(0);
//        else robot.armServo.setPosition(.5);



        // Send telemetry message to signify robot running;
        //telemetry.addData("claw",  "Offset = %.2f", clawOffset);
        //telemetry.addData("left",  "%.2f", left);
        //telemetry.addData("right", "%.2f", right);
    }



    @Override
    public void stop() {
    }


}
