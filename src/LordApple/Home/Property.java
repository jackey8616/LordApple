package LordApple.Home;

import LordApple.Images;
import org.opencv.core.Size;
import org.sikuli.script.Region;

public class Property {

    enum PropertyImages {
        HasProperty(106, 12, "Images/HasProperty.png"), Manage(124, 43, "Images/Manage.png");
        public Size size;
        public String path;

        PropertyImages(int x, int y, String path) {
            this.size = new Size(x, y);
            this.path = path;
        }
    }

    public static void propertyClear(Region gameRegion) throws Exception {
        if(gameRegion.exists(PropertyImages.HasProperty.path) != null) {
            gameRegion.click(PropertyImages.HasProperty.path);
            gameRegion.wait(Images.Exit.path);
            while(gameRegion.exists(PropertyImages.Manage.path) != null) {
                gameRegion.click(PropertyImages.Manage.path);
                gameRegion.wait(1.0);
            }
            gameRegion.wait(Images.Exit.path);
            gameRegion.click(Images.Exit.path);
        }
    }

}
