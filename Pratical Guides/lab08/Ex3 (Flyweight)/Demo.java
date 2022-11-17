package Ex3;

import java.awt.Color;
import java.util.ArrayList;
import Ex3.startypes.*;

public class Demo {
    static int CANVAS_SIZE = 1200;
    static int STARS_TO_DRAW = 1000000;
    
    public static void main(String[] args) {
        Sky sky = new Sky();

        StarType A = new AStar();
        StarType B = new BStar();
        StarType F = new FStar();
        StarType G = new GStar();
        StarType K = new KStar();
        StarType M = new MStar();
        StarType O = new OStar();

        // https://astrobackyard.com/wp-content/uploads/2020/03/types-of-stars.jpg
        StarType[] starTypes = {O, B, A, F, G, K, M};
        StarType type;

		Runtime runtime = Runtime.getRuntime();
		long before = runtime.totalMemory() - runtime.freeMemory();

        for (int i = 0; i < STARS_TO_DRAW; i++) {
            type = starTypes[random(0, starTypes.length-1)];
            /*int x = random(0, CANVAS_SIZE);
            int y = random(0, CANVAS_SIZE);*/
            /*ArrayList<Object> starData = createStar(type);
            int size = (Integer) (starData.get(0));
            Color color = (Color) starData.get(1);
            String description = starData.get(2).toString();*/
            sky.placeStar(createStar(type));
        }
        sky.setSize(CANVAS_SIZE, CANVAS_SIZE);
        sky.setBackground(Color.BLACK);
        sky.setVisible(true);

        long after = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory: " + (after - before) / 1024 / 1024 + " MB");

    }

    private static Star createStar(StarType type) {
        int x = random(0, CANVAS_SIZE);
        int y = random(0, CANVAS_SIZE);
        Star star = new Star(x, y, type);

        return star;
    }
    /*private static ArrayList<Object> createStar(char type) {
        ArrayList<Object> data = new ArrayList<Object>();
        int size = 0;
        Color color = null;
        String description = null;
        switch (type) {
            case 'O' :
                size = 5;
                color = new Color(225, 250, 250);
                description = "This is a long description of the O type star....";
                break;
            case 'A' :
                size = 2;
                color = Color.WHITE;
                description = "This is a long description of the A type star....";
                break;
            case 'B' :
                size = 5;
                color = new Color(230, 252, 252);
                description = "This is a long description of the B type star....";
                break;
            case 'F' :
                size = 2;
                color = new Color(255, 255, 245);
                description = "This is a long description of the F type star....";
                break;
            case 'G' :
                size = 1;
                color = new Color(245, 250, 250);
                description = "This is a long description of the G type star....";
                break;
            case 'K' :
                size = 1;
                color = new Color(230, 160, 10);
                description = "This is a long description of the K type star....";
                break;
            case 'M' :
                size = 1;
                color = Color.RED;
                description = "This is a long description of the M type star....";
                break;
        }
        data.add(size); data.add(color); data.add(description);
        return data;
    }*/

	private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}