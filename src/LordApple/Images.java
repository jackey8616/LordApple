package LordApple;

import org.opencv.core.Size;

public enum Images {
    BackHome(55, 37, "Images/BackHome.png"), OutHone(49, 37, "Images/OutHome.png"),
    Rank(22, 45, "Images/Rank.png"),
    Exit(28, 17, "Images/Exit.png");

    public Size size;
    public String path;

    Images(int x, int y, String path) {
        this.size = new Size(x, y);
        this.path = path;
    }

}
