import com.infoshareacademy.jjdd4.wildhogs.SkeletonMenu;

public class SkeletonMain {
    public SkeletonMain() {
    }
    public static void main(String[] args) {
        SkeletonMenu menu = new SkeletonMenu("Menu", "Home", "Weeklist", "KitchenBook");
        menu.printSkeletonMenu();
    }
}
