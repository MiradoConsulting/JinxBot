
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Jinx extends Robot {

    public void run() {
        while(true) {
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
        turnGunRight(1);
        fire(1);
        turnGunRight(1);
        fire(1);
        turnGunRight(1);
        fire(1);
        turnGunRight(1);
        fire(1);
        turnGunRight(1);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        turnLeft(10);
    }
}
