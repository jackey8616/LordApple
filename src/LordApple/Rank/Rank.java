package LordApple.Rank;

import LordApple.Images;
import org.opencv.core.Size;
import org.sikuli.script.Location;
import org.sikuli.script.Region;

public class Rank {

    public enum RankImages {
        RankTitle(143, 45, "Images/RankTitle.png"), Quit(79, 32, "Images/Quit.png");

        public Size size;
        public String path;

        RankImages(int x, int y, String path) {
            this.size = new Size(x, y);
            this.path = path;
        }

    }

    public static void process(Region gameRegion) {
        try {
            locate(gameRegion);
            gameRegion.click(RankImages.Quit.path);
            gameRegion.wait(60.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void locate(Region gameRegion) throws Exception {
        if(gameRegion.exists(RankImages.RankTitle.path) != null)
            return;
        if(gameRegion.exists(Images.Rank.path) == null) {
            Location l = new Location(gameRegion.getX(), gameRegion.getY());
            gameRegion.dragDrop(new Location(l.getX() + gameRegion.w - 1, l.getY() + gameRegion.h / 2), new Location(l.getX() - gameRegion.w * 2, l.getY() + gameRegion.h / 2));
        }
        gameRegion.click(Images.Rank.path);
        gameRegion.wait(RankImages.RankTitle.path);
    }


}
