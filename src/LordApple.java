import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class LordApple {

    private static Screen globalScreen = new Screen();
    private static int width = 512, height = 979;
    private static Location zeroPoint;
    private static Region gameRegion;


    private static void initGameRegion() {
        try {
            Match m = globalScreen.find(Images.BackHome.path);
            zeroPoint = new Location(m.getX() - 449, m.getY() - 52);
            gameRegion = new Region(zeroPoint.getX(), zeroPoint.getY(), width, height);
            System.out.println(zeroPoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void homeLocate() throws Exception {
        if(gameRegion.exists(Images.OutHone.path) != null ||  gameRegion.exists(Images.Exit.path) != null)
            return;
        gameRegion.click(Images.BackHome.path);
        gameRegion.wait(Images.OutHone.path);
    }

    private static void propertyClear() throws Exception {
        if(gameRegion.exists(Images.HasProperty.path) != null) {
            gameRegion.click(Images.HasProperty.path);
            gameRegion.wait(Images.Exit.path);
            while(gameRegion.exists(Images.Manage.path) != null) {
                gameRegion.click(Images.Manage.path);
                gameRegion.wait(1.0);
            }
            gameRegion.wait(Images.Exit.path);
            gameRegion.click(Images.Exit.path);
        }
    }

    private static void eventClear() throws Exception {
        if(gameRegion.exists(Images.HasEvent.path) != null) {
            gameRegion.click(Images.HasEvent.path);
            gameRegion.wait(Images.Exit.path);
            while(gameRegion.exists(Images.Work.path) != null) {
                gameRegion.click(Images.Work.path);
                gameRegion.wait(1.0);
            }
            gameRegion.wait(Images.Exit.path);
            gameRegion.click(Images.Exit.path);
        }
    }

    private static void wifeClear() throws Exception {
        if(gameRegion.exists(Images.HasWife.path) != null) {
            gameRegion.click(Images.HasWife.path);
            gameRegion.wait(Images.Exit.path);
            while(gameRegion.exists(Images.Call.path) != null) {
                gameRegion.click(Images.Call.path);
                gameRegion.wait(3.5);
                gameRegion.wait(Images.Bubble.path);
                gameRegion.click(Images.Bubble.path);
                if(gameRegion.exists(Images.GotSon.path) != null) {
                    gameRegion.click(Images.No.path);
                }
            }
            gameRegion.wait(Images.Exit.path);
            gameRegion.click(Images.Exit.path);
        }
    }

    public static void main(String[] args) {
        initGameRegion();
        while(true) {
            try {
                homeLocate();
                propertyClear();
                eventClear();
                wifeClear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
