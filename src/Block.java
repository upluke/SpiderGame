import java.awt.*;

public class Block {
    private Rectangle bounds;
    private Color color;

    public Block(int x, int y, int w, int h, Color color){
        bounds= new Rectangle(x, y, w, h);
        this.color=color;
    }

    public int getX(){return bounds.x;}
    public int getY(){return bounds.y;}
    public void move(int x, int y){
        System.out.println("block move: " + x + " " + y);
        bounds.x = x;
        bounds.y = y;
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);

    }

    public boolean contains(int x, int y){
        return this.bounds.contains(x, y);
    }
}
