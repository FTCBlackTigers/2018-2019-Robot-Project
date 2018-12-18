/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.Autonomous.AutoBlue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RobotSystems.Climbing;
import org.firstinspires.ftc.teamcode.RobotSystems.Drive;
import org.firstinspires.ftc.teamcode.RobotSystems.Robot;

/**
 * doing Landing, Team Marker and Parking
 * PTS= 50
 * In Case of no Pixy
 * Starting from BlueDepot On The Lander
 */
@Autonomous(name = "Blue7", group = "Tests")
public class Blue7 extends LinearOpMode {

  private Robot robot = new Robot();
  private ElapsedTime runtime = new ElapsedTime();


  @Override
  public void runOpMode() throws InterruptedException {
    robot.init(hardwareMap , this);
    robot.intake.leftServo.setPosition(0.15);
    robot.intake.rightServo.setPosition(0.7);
    robot.climbing.lockServo();
    telemetry.addLine("Yeve is mitragesh");
    telemetry.update();
    waitForStart();
    robot.climbing.moveAngle(Climbing.Angle.STARTPOS);
    sleep(2050);
    robot.climbing.moveLift(Climbing.Height.MEDIUM);
    sleep(2050);
    robot.climbing.moveAngle(Climbing.Angle.CLIMB);
    sleep(2500);
    robot.climbing.moveLift(Climbing.Height.MAX);
    sleep(2500);
    robot.climbing.openServo();
    sleep(2500);
    robot.climbing.moveLift(Climbing.Height.MIN);
    sleep(2500);
    robot.drive.driveByEncoder(75, 0.3, Drive.Direction.BACKWARD, 5000);
    sleep(2500);
    robot.climbing.moveAngle(Climbing.Angle.DOWN);
    robot.intake.collect(); //released the Team Marker
    sleep(1500);
    robot.intake.stopMotor();
   // robot.drive.turnByGyroAbsolut(-100, 2000);
   // robot.drive.driveByEncoder(100, 0.3, Drive.Direction.BACKWARD, 5000);


  }
}