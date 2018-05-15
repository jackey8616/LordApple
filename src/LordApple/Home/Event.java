package LordApple.Home;

import LordApple.Images;
import org.opencv.core.Size;
import org.sikuli.script.Region;

public class Event {

    enum EventImages {
        HasEvent(94, 14, "Images/HasEvent.png"), Work(31, 17, "Images/Work.png");
        public Size size;
        public String path;

        EventImages(int x, int y, String path) {
            this.size = new Size(x, y);
            this.path = path;
        }
    }

    public static void eventClear(Region gameRegion) throws Exception {
        if(gameRegion.exists(EventImages.HasEvent.path) != null) {
            gameRegion.click(EventImages.HasEvent.path);
            gameRegion.wait(Images.Exit.path);
            while(gameRegion.exists(EventImages.Work.path) != null) {
                gameRegion.click(EventImages.Work.path);
                gameRegion.wait(1.0);
            }
            gameRegion.wait(Images.Exit.path);
            gameRegion.click(Images.Exit.path);
        }
    }


}
