package org.firstinspires.ftc.teamcode;

import android.graphics.Color;
import android.view.View;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;


//@Autonomous(name="Pushbot: Team8648 Encoder Autonomous Depot", group="Pushbot")
//@Disabled
public class EncoderDepotAutonomous8648 extends LinearOpMode {

    Team8648HardwarePushbot robot = new Team8648HardwarePushbot();
    HardwareMap hwMap = null;


    NormalizedColorSensor colorSensor;
    /**
     * The relativeLayout field is used to aid in providing interesting visual feedback
     * in this sample application; you probably *don't* need something analogous when you
     * use a color sensor on your robot
     */
    View relativeLayout;

    private ElapsedTime runtime = new ElapsedTime();
    // Detector object
    private GoldAlignDetector detector;

    static final double COUNTS_PER_MOTOR_REV = 1120;    // eg: Andy Mark Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 2.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.3;
    static final double TURN_SPEED = 0.5;


    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        telemetry.addData("Status", "DogeCV 2018.0 - Gold Align Example");

        // Set up detector
        detector = new GoldAlignDetector(); // Create detector
        detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance()); // Initialize it with the app context and camera
        detector.useDefaults(); // Set detector to use default settings

        // Optional tuning
        detector.alignSize = 200; // How wide (in pixels) is the range in which the gold object will be aligned. (Represented by green bars in the preview)
        detector.alignPosOffset = 0; // How far from center frame to offset this alignment zone.
        detector.downscale = 0.4; // How much to downscale the input frames

        detector.areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Can also be PERFECT_AREA
        //detector.perfectAreaScorer.perfectArea = 10000; // if using PERFECT_AREA scoring
        detector.maxAreaScorer.weight = 0.005; //

        detector.ratioScorer.weight = 5; //
        detector.ratioScorer.perfectRatio = 1.0; // Ratio adjustment

        detector.enable(); // Start the detector!


        //robot.colorSensor = hwMap.get(NormalizedColorSensor.class, "ColorSensor");

        robot.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;
        // bLedOn represents the state of the LED.
        boolean bLedOn = true;

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // convert the RGB values to HSV values.
        Color.RGBToHSV(robot.colorSensor.red() * 8, robot.colorSensor.green() * 8, robot.colorSensor.blue() * 8, hsvValues);


        //robot.colorSensor.enableLed(bLedOn);

        if ((detector.getXPosition() < 680) && (detector.getXPosition() > 405)) {

            detector.disable();
            //robot.lift.setPower(.48);
            //sleep(2600);
            //encoderLift(DRIVE_SPEED, 10, 0);

            encoderLiftWithoutTime(DRIVE_SPEED, 4);



            //robot.lift.setPower(0);

            //sleep(500);

            //backup
            //encoderDrive(DRIVE_SPEED,  -2.5,  -2.5, 1.0);






//            robot.lift.setPower(0);
//
//            robot.rightDrive.setPower(-0.5);
//            robot.leftDrive.setPower(-0.5);
//            sleep(350);
//
//            robot.leftDrive.setPower(0);
//            robot.rightDrive.setPower(0);
//            sleep(500);
//
//            robot.rightDrive.setPower(0.75);
//            robot.leftDrive.setPower(-0.75);
//            sleep(400);
//
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(500);
//
//            robot.rightDrive.setPower(0.5);
//            robot.leftDrive.setPower(0.5);
//            //sleep(250);
//            sleep(500);
//
//
//            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(1000);
//
//
//            //forward
//            robot.rightDrive.setPower(0.5);
//            robot.leftDrive.setPower(0.5);
//            sleep(500);
////
//            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(1000);
////
//            //turn to left
//            robot.rightDrive.setPower(0.75);
//            robot.leftDrive.setPower(-0.75);
//            sleep(650);
////
//            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(1000);
////
//            //Drive forward
//            robot.rightDrive.setPower(0.15);
//            robot.leftDrive.setPower(0.15);
//            sleep(500);
////
////            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(1000);
//
//            robot.markServo.setPosition(0);
//

            }
            else if ((detector.getXPosition() < 385) && (detector.getXPosition() > 180)) {

            detector.disable();
            robot.lift.setPower(.48);


            sleep(2750);

            robot.lift.setPower(0);

            robot.rightDrive.setPower(-0.5);
            robot.leftDrive.setPower(-0.5);
            sleep(350);

            robot.leftDrive.setPower(0);
            robot.rightDrive.setPower(0);
            sleep(500);

            robot.rightDrive.setPower(0.75);
            robot.leftDrive.setPower(-0.75);
            sleep(470);

            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(500);

            robot.rightDrive.setPower(0.5);
            robot.leftDrive.setPower(0.5);
            //sleep(250);
            sleep(380);

            //stop
            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(1000);

            //forward
            robot.rightDrive.setPower(0.5);
            robot.leftDrive.setPower(0.5);
            sleep(650);
//
            //stop
            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(1000);
//
            //turn to left
//            robot.rightDrive.setPower(0.75);
//            robot.leftDrive.setPower(-0.75);
//            sleep(650);
//
            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(1000);
////
//            //Drive forward
//            robot.rightDrive.setPower(0.15);
//            robot.leftDrive.setPower(0.15);
//            sleep(1000);
////
////            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(1000);
////
////            //turn to left
//            robot.rightDrive.setPower(0.75);
//            robot.leftDrive.setPower(-0.75);
//            sleep(200);
////
////            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(1000);
////
////            //Drive forward
//            robot.rightDrive.setPower(0.5);
//            robot.leftDrive.setPower(0.5);
//            sleep(1000);
////
////            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(900);
//
//            //Drop the marker
            robot.markServo.setPosition(0);


        } else {
            detector.disable();
            robot.lift.setPower(.48);


            sleep(2750);

            robot.lift.setPower(0);

            robot.rightDrive.setPower(-0.5);
            robot.leftDrive.setPower(-0.5);
            sleep(350);

            robot.leftDrive.setPower(0);
            robot.rightDrive.setPower(0);
            sleep(1000);

            robot.rightDrive.setPower(0.75);
            robot.leftDrive.setPower(-0.75);
            sleep(750);

            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(1000);

            robot.rightDrive.setPower(0.5);
            robot.leftDrive.setPower(0.5);
            sleep(450);

            //stop
            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(1000);


            //forward
            robot.rightDrive.setPower(0.5);
            robot.leftDrive.setPower(0.5);
            sleep(300);
//
            //stop
            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(1000);
//
            //turn to left
            robot.rightDrive.setPower(-0.75);
            robot.leftDrive.setPower(0.75);
            sleep(450);
//
            //stop
            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(1000);
//
            //Drive forward
            robot.rightDrive.setPower(0.15);
            robot.leftDrive.setPower(0.15);
            sleep(1000);
//
//            //stop
            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(1000);
//
//            //turn to left
//            robot.rightDrive.setPower(0.75);
//            robot.leftDrive.setPower(-0.75);
//            sleep(200);
////
////            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(1000);
////
////            //Drive forward
//            robot.rightDrive.setPower(0.5);
//            robot.leftDrive.setPower(0.5);
//            sleep(1000);
////
////            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(900);
//
//            //Drop the marker
            robot.markServo.setPosition(0);


        }
    }

    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) {
        int newLeftTarget;
        int newRightTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = robot.leftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newRightTarget = robot.rightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            robot.leftDrive.setTargetPosition(newLeftTarget);
            robot.rightDrive.setTargetPosition(newRightTarget);

            // Turn On RUN_TO_POSITION
            robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            robot.leftDrive.setPower(Math.abs(speed));
            robot.rightDrive.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (robot.leftDrive.isBusy() && robot.rightDrive.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        robot.leftDrive.getCurrentPosition(),
                        robot.rightDrive.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            robot.leftDrive.setPower(0);
            robot.rightDrive.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }


    public void encoderLift(double speed,
                            double inches,
                            double timeoutS) {

        int target;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller

            target = robot.lift.getCurrentPosition() + (int) (inches * COUNTS_PER_INCH);

            robot.lift.setTargetPosition(target);

            // Turn On RUN_TO_POSITION

            robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            // reset the timeout time and start motion.
            runtime.reset();


            robot.lift.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (robot.lift.isBusy())) {

                // Display it for the driver.
                //telemetry.addData("Path1", "Running to %7d :%7d", target);
                //telemetry.addData("Path2", "Running at %7d :%7d",
                        robot.lift.getCurrentPosition();
                telemetry.update();
            }



//            while (opModeIsActive() &&
//                    (runtime.seconds() < timeoutS) &&
//                    (robot.leftDrive.isBusy() && robot.rightDrive.isBusy())) {
//
//                // Display it for the driver.
//                telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
//                telemetry.addData("Path2", "Running at %7d :%7d",
//                        robot.leftDrive.getCurrentPosition(),
//                        robot.rightDrive.getCurrentPosition());
//                telemetry.update();
//            }
//
            // Stop all motion;


        }

    }


    public void encoderLiftWithoutTime(double speed,
                            double inches) {
        int target;
        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller

            target = robot.lift.getCurrentPosition() + (int) (inches * COUNTS_PER_INCH);

            //target = (int)inches;

            robot.lift.setTargetPosition(target);

            // Turn On RUN_TO_POSITION

            robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            // reset the timeout time and start motion.
            runtime.reset();


            robot.lift.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            while (opModeIsActive() && (robot.lift.isBusy())) {

                // Display it for the driver.
                //telemetry.addData("Path1", "Running to %7d :%7d", target);
                //telemetry.addData("Path2", "Running at %7d :%7d",
                robot.lift.getCurrentPosition();
                telemetry.update();
            }

            robot.lift.setPower(0);
            //robot.rightDrive.setPower(0);

            // Turn off RUN_TO_POSITION
            //robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }

    }

}