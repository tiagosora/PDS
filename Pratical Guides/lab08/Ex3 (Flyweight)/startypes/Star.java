package Ex3.startypes;
import java.awt.*;

public class Star {
    private int x;
    private int y;
    private StarType type;

    public Star (int x, int y, StarType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        type.draw(g, this.x, this.y);
    }
}