
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;

public class Jinx extends Robot {

    public void run() {
        setAllColors(Color.cyan);
        while(true) {
            back(50);
            turnGunLeft(180);
            turnLeft(5);
            ahead(100);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        if(getEnergy() > 1) {
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
