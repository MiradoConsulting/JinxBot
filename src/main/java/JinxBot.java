
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class JinxBot extends Robot {

    public void run() {
        while(true) {
            scan();
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
}
