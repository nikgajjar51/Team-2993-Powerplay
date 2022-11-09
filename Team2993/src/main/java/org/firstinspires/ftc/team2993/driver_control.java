package org.firstinspires.ftc.team2993;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
public class driver_control {
    public robot_config robot = new robot_config(hardwareMap);
    public void meccanum_drive_control(double speed) {
        double deadZoneDriveX = .5, deadZoneDriveY = .5, deadZoneDriveRotate = .5;
        if (Math.abs( gamepad1.left_stick_x) < 0.05) {
            deadZoneDriveX = 0;
        } else {
            deadZoneDriveX = -gamepad1.left_stick_x;
        }
        if (Math.abs(gamepad1.left_stick_y) < 0.05) {
            deadZoneDriveY = 0;
        } else {
            deadZoneDriveY = gamepad1.left_stick_y;
        }
        if (Math.abs(gamepad1.right_stick_x) < 0.05) {
            deadZoneDriveRotate = 0;
        } else {
            deadZoneDriveRotate = gamepad1.right_stick_x;
        }
        double r = Math.hypot(deadZoneDriveX, -deadZoneDriveY);
        double robotAngle = Math.atan2(-deadZoneDriveY, deadZoneDriveX) - Math.PI / 4;
        double rightX = deadZoneDriveRotate / 1.25;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;
        robot.frontRight.setPower(v1 * speed);
        robot.frontLeft.setPower(v2 * speed);
        robot.backRight.setPower(v3 * speed);
        robot.backLeft.setPower(v4 * speed);
    }
}
