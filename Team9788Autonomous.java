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


//@Autonomous(name="Pushbot: Team9788 Autonomous", group="Pushbot")
//@Disabled
public class Team9788Autonomous extends LinearOpMode {

    Team9788HardwarePushbot robot = new Team9788HardwarePushbot();
    HardwareMap hwMap           =  null;


    NormalizedColorSensor colorSensor;
    /** The relativeLayout field is used to aid in providing interesting visual feedback
     * in this sample application; you probably *don't* need something analogous when you
     * use a color sensor on your robot */
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
        float hsvValues[] = {0F,0F,0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;
        // bLedOn represents the state of the LED.
        boolean bLedOn = true;

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // convert the RGB values to HSV values.
        //Color.RGBToHSV(robot.colorSensor.red() * 8, robot.colorSensor.green() * 8, robot.colorSensor.blue() * 8, hsvValues);

        robot.green.setPower(.48);


        sleep(2500);

        robot.green.setPower(0);

        //encoderDrive(DRIVE_SPEED,  1,  1, 3);  // S1: Forward 47 Inches with 5 Sec timeout
        robot.rightDrive.setPower(-0.5);
        robot.leftDrive.setPower(-0.5);
        sleep(350);

        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
        sleep(500);

        robot.rightDrive.setPower(0.75);
        robot.leftDrive.setPower(-0.75);
        sleep(750);

        robot.rightDrive.setPower(0);
        robot.leftDrive.setPower(0);
        sleep(500);

        sleep(2500);


        telemetry.addData("IsAligned" , detector.getAligned()); // Is the bot aligned with the gold mineral?
        telemetry.addData("X Pos" , detector.getXPosition()); // Gold X position.




        //robot.colorSensor.enableLed(bLedOn);

        if((detector.getXPosition() < 680)  && (detector.getXPosition() > 405)){

            detector.disable();
            robot.green.setPower(.48);
            sleep(2750);

            robot.green.setPower(0);

            robot.rightDrive.setPower(-0.5);
            robot.leftDrive.setPower(-0.5);
            sleep(350);

            robot.leftDrive.setPower(0);
            robot.rightDrive.setPower(0);
            sleep(500);

            robot.rightDrive.setPower(-0.75);
            robot.leftDrive.setPower(0.75);
            sleep(325);

            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(500);

            robot.rightDrive.setPower(0.5);
            robot.leftDrive.setPower(0.5);
            //sleep(250);
            sleep(500);

//            //backwards
//            robot.rightDrive.setPower(-0.5);
//            robot.leftDrive.setPower(-0.5);
//            sleep(600);
//
//            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(500);
//
//            //turn to left
//            robot.rightDrive.setPower(0.75);
//            robot.leftDrive.setPower(-0.75);
//            sleep(650);
//
//            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(500);
//
//            //Drive forward
//            robot.rightDrive.setPower(0.5);
//            robot.leftDrive.setPower(0.5);
//            sleep(1500);
//
//            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(500);
//
//            //turn to left
//            robot.rightDrive.setPower(0.75);
//            robot.leftDrive.setPower(-0.75);
//            sleep(250);
//
//            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(500);
//
//            //Drive forward
//            robot.rightDrive.setPower(0.5);
//            robot.leftDrive.setPower(0.5);
//            sleep(1000);
//
//            //stop
//            robot.rightDrive.setPower(0);
//            robot.leftDrive.setPower(0);
//            sleep(500);
//
//            //Drop the marker
//            robot.markServo.setPosition(0);

            telemetry.addData("IsAligned" , detector.getAligned()); // Is the bot aligned with the gold mineral?
            telemetry.addData("X Pos" , detector.getXPosition()); // Gold X position.
        }
        else if((detector.getXPosition() < 350)  && (detector.getXPosition() > 180)){

            detector.disable();
            robot.green.setPower(.48);


            sleep(2750);

            robot.green.setPower(0);

            robot.rightDrive.setPower(-0.5);
            robot.leftDrive.setPower(-0.5);
            sleep(350);

            robot.leftDrive.setPower(0);
            robot.rightDrive.setPower(0);
            sleep(500);

            robot.rightDrive.setPower(-0.75);
            robot.leftDrive.setPower(0.75);
            sleep(560);

            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(500);

            robot.rightDrive.setPower(0.5);
            robot.leftDrive.setPower(0.5);
            //sleep(250);

            sleep(380);

        }
        else{
            detector.disable();
            robot.green.setPower(.48);


            sleep(2750);

            robot.green.setPower(0);

            robot.rightDrive.setPower(-0.5);
            robot.leftDrive.setPower(-0.5);
            sleep(350);

            robot.leftDrive.setPower(0);
            robot.rightDrive.setPower(0);
            sleep(500);

            robot.rightDrive.setPower(-0.75);
            robot.leftDrive.setPower(0.75);
            sleep(825);

            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            sleep(500);

            robot.rightDrive.setPower(0.5);
            robot.leftDrive.setPower(0.5);
            //sleep(250);

            sleep(500);
        }





    }


}
