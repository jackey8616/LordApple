package LordApple;

import LordApple.Home.Home;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import java.util.ArrayList;
import java.util.Iterator;

public class LordApple {

    private static Screen globalScreen = new Screen();
    private static int width = 512, height = 979;
    private static Location zeroPoint;
    private static ArrayList<Region> gameRegion = new ArrayList<Region>();

    private static void initGameRegion() {
        try {
            globalScreen.wait(5.0);
            System.out.println("Start game detect");
            Iterator<Match> matches = globalScreen.findAll(Images.BackHome.path);
            gameRegion.clear();
            while(matches.hasNext()) {
                Match m = matches.next();
                zeroPoint = new Location(m.getX() - 449, m.getY() - 52);
                gameRegion.add(new Region(zeroPoint.getX(), zeroPoint.getY(), width, height));
                System.out.println(zeroPoint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        while(true) {
            initGameRegion();
            for (Region region : gameRegion) {
                Home.process(region);
                //Rank.process(region);
            }
            globalScreen.wait(5.0);
            System.out.println("Loop over");
        }
    }


}
