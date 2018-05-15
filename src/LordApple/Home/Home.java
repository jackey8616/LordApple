package LordApple.Home;

import LordApple.Images;
import org.opencv.core.Size;
import org.sikuli.script.Region;

public class Home {

    public enum HomeImages {
        HOME(0, 0, "");

        public Size size;
        public String path;

        HomeImages(int x, int y, String path) {
            this.size = new Size(x, y);
            this.path = path;
        }

    }


    public static void process(Region gameRegion) {
        try {
            homeLocate(gameRegion);
            Property.propertyClear(gameRegion);
            Event.eventClear(gameRegion);
            Wife.wifeClear(gameRegion);
            gameRegion.click(Images.OutHone.path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void homeLocate(Region gameRegion) throws Exception {
        if(gameRegion.exists(Images.OutHone.path) != null ||  gameRegion.exists(Images.Exit.path) != null)
            return;
        gameRegion.click(Images.BackHome.path);
        gameRegion.wait(Images.OutHone.path);
    }

}
