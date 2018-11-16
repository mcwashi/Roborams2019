package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.view.View;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;

public class Team8648HardwarePushbot {

    /* Public OpMode members. */
    public DcMotor leftDrive   = null;
    public DcMotor rightDrive  = null;
    public DcMotor lift     = null;
    public DcMotor arm    = null;
    public DcMotor armRaise = null;
    public DcMotor armRaise2 = null;
    public Servo    leftClaw    = null;
    public Servo    rightClaw   = null;
    public Servo    markServo   = null;
    public ColorSensor colorSensor;




    public static final double MID_SERVO       =  0.25;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Team8648HardwarePushbot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        //ColorSensor colorSensor;

        // Define and Initialize Motors
        leftDrive  = hwMap.get(DcMotor.class, "LeftMotor");
        rightDrive = hwMap.get(DcMotor.class, "RightMotor");
        lift    = hwMap.get(DcMotor.class, "LiftMotor");
        arm   = hwMap.get(DcMotor.class, "ArmMotor");
        armRaise = hwMap.get(DcMotor.class, "ArmRaiseMotor");
        armRaise2 = hwMap.get(DcMotor.class, "ArmRaiseMotor2");



        colorSensor = hwMap.get(ColorSensor.class, "ColorSensor");
        colorSensor.enableLed(true);

        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        armRaise.setDirection(DcMotor.Direction.FORWARD);
        armRaise2.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        lift.setPower(0);
        arm.setPower(0);
        armRaise.setPower(0);
        armRaise2.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armRaise.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armRaise2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armRaise.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armRaise2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        // Define and initialize ALL installed servos.
        leftClaw  = hwMap.get(Servo.class, "leftServo");
        rightClaw = hwMap.get(Servo.class, "rightServo");
        markServo = hwMap.get(Servo.class, "markServo");
        leftClaw.setPosition(MID_SERVO);
        rightClaw.setPosition(MID_SERVO);
        //markServo.setPosition(1);

    }
}
