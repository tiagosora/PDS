package Ex3;

import Ex3.startypes.Star;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sky extends JFrame {
    private List<Star> stars = new ArrayList<>();

    public void placeStar(Star star) {
        // StarType type = StarFactory.getStarType(size, color, description);
        // Star star = new Star(x, y, type);
        stars.add(star);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Star star : stars) {
            star.draw(graphics);
        }
    }
}