package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Fredrik on 31/10/2015.
 */
public class EmuOp extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor boxLift;
    DcMotor intake;

    boolean tank;

    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        boxLift = hardwareMap.dcMotor.get("box_lift");
        intake = hardwareMap.dcMotor.get("intake");

        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        tank = false;
    }

    public void loop(){
        float leftPower;
        float rightPower;

        float x1 = gamepad1.left_stick_x;
        float y1 = gamepad1.left_stick_y;
        float x2 = gamepad1.right_stick_x;
        float y2 = gamepad1.right_stick_y;

        if (tank){
            leftPower = y1;
            rightPower = y2;
        }
        else{
            leftPower = y1 - x2;
            rightPower = y1 + x2;
        }

        leftPower *= Math.abs(leftPower);
        rightPower *= Math.abs(rightPower);

        leftPower = Range.clip(leftPower, -1, 1);
        rightPower = Range.clip(rightPower, -1, 1);

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);

        if (gamepad2.y) {
            boxLift.setPower(1);
        }
        else if (gamepad2.a){
            boxLift.setPower(-1);
        }
        else{
            boxLift.setPower(0);
        }

        if (gamepad2.b){
            intake.setPower(1);
        }
        else{
            intake.setPower(0);
        }

        if (gamepad1.x){
            tank = true;
        }
        else if (gamepad1.b){
            tank = false;
        }
    }
}
