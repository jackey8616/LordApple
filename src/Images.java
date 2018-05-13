import org.opencv.core.Size;

public enum Images {
    BackHome(55, 37, "Images/BackHome.png"), OutHone(49, 37, "Images/OutHome.png"),
    HasProperty(106, 12, "Images/HasProperty.png"), Manage(124, 43, "Images/Manage.png"),
    HasEvent(94, 14, "Images/HasEvent.png"), Work(31, 17, "Images/Work.png"),
    HasWife(100, 14, "Images/HasWife.png"), Call(70, 19, "Images/Call.png"), Bubble(19, 15, "Images/Bubble.png"), GotSon(127, 113, "Images/GotSon.png"), No(21, 20, "Images/No.png'"),
    Exit(28, 17, "Images/Exit.png");
    Size size;
    String path;

     Images(int x, int y, String path) {
         this.size = new Size(x, y);
         this.path = path;
     }

}
