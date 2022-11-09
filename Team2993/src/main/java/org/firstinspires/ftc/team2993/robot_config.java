package org.firstinspires.ftc.team2993;
import androidx.annotation.NonNull;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class robot_config {
    public DcMotorEx frontRight, backRight, backLeft, frontLeft;

    public robot_config(@NonNull HardwareMap map) {
        frontRight = map.get(DcMotorEx.class, "MotorC0");
        frontRight.setDirection(DcMotorEx.Direction.FORWARD);
        backRight = map.get(DcMotorEx.class, "MotorC1");
        backRight.setDirection(DcMotorEx.Direction.FORWARD);
        backLeft = map.get(DcMotorEx.class, "MotorC2");
        backLeft.setDirection(DcMotorEx.Direction.REVERSE);
        frontLeft = map.get(DcMotorEx.class, "MotorC3");
        frontLeft.setDirection(DcMotorEx.Direction.REVERSE);
        BNO055IMU imu = map.get(BNO055IMU.class, "IMU");
    }
}
