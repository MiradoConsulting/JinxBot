
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;

public class Jinx extends Robot {

    public void run() {
        setAllColors(Color.cyan);
        while(true) {
            back(50);
            turnRadarLeft(360);
            turnLeft(5);
            ahead(100);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        double bearing = event.getBearing();
        double gunHeading = getGunHeading();

        double diff = bearing - gunHeading;
        turnGunLeft(diff);
        fire(1);
        turnGunLeft(1);
        fire(1);
        turnGunRight(2);
        fire(1);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        turnLeft(45);
    }
}
