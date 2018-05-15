package LordApple.Home;

import LordApple.Images;
import org.opencv.core.Size;
import org.sikuli.script.Region;

public class Wife {

    public enum WifeImages {
        HasWife(100, 14, "Images/HasWife.png"), Call(70, 19, "Images/Call.png"), Bubble(19, 15, "Images/Bubble.png"), GotSon(127, 113, "Images/GotSon.png"), No(21, 20, "Images/No.png'");

        public Size size;
        public String path;

        WifeImages(int x, int y, String path) {
            this.size = new Size(x, y);
            this.path = path;
        }

    }

    public static void wifeClear(Region gameRegion) throws Exception {
        if(gameRegion.exists(WifeImages.HasWife.path) != null) {
            gameRegion.click(WifeImages.HasWife.path);
            gameRegion.wait(Images.Exit.path);
            while(gameRegion.exists(WifeImages.Call.path) != null) {
                gameRegion.click(WifeImages.Call.path);
                gameRegion.wait(3.5);
                gameRegion.wait(WifeImages.Bubble.path);
                gameRegion.click(WifeImages.Bubble.path);
                if(gameRegion.exists(WifeImages.GotSon.path) != null) {
                    gameRegion.click(WifeImages.No.path);
                }
            }
            gameRegion.wait(Images.Exit.path);
            gameRegion.click(Images.Exit.path);
        }
    }

}
