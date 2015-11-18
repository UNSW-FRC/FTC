package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Timer;

/**
 * Created by Fredrik on 1/11/2015.
 */
public class EmuAuto extends LinearOpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor boxLift;
    DcMotor intake;

    public void runOpMode() throws InterruptedException {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        leftMotor.setPower(0.5);
        rightMotor.setPower(0.5);

        sleep(1000);

        rightMotor.setPower(0);

        sleep(2000);

        rightMotor.setPower(0.5);

        sleep(1000);

        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}
