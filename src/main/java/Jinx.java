
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;

public class Jinx extends Robot {

    public void mode1() {
        setAllColors(Color.cyan);
        setGunColor(Color.MAGENTA);
        setRadarColor(Color.MAGENTA);
        back(100);
        turnGunLeft(180);
        turnLeft(15);
        ahead(300);
        turnGunLeft(180);
        turnLeft(15);

    }

    public void mode2() {
        setAllColors(Color.BLUE);
        setGunColor(Color.black);
        setRadarColor(Color.black);
        ahead(1);
        turnLeft(1);
        turnGunLeft(1);
    }

    int mode = 1;
long round = 0;

    public void run() {

        while(true) {
            round ++;
            if(mode == 1) {
                mode1();
            } else {
                mode2();
            }

            if(round > 100) {
                round = 100;
                if(Math.random() > 0.5) {
                    mode = 1;
                } else {
                    mode = 2;
                }
            }
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        if(getEnergy() > 1 && event.getDistance() < 300) {
            fire(1);
        }
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        turnLeft(45);
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        double gunHeading = getGunHeading();
        turnGunLeft(gunHeading);
        fire(10);
    }
}
