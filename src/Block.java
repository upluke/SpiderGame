import java.awt.*;

public class Block {
    private Rectangle bounds;
    private Color color;
    public Block(int x, int y, int w, int h, Color color){
        bounds= new Rectangle(x, y, w, h);
        this.color=color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);

    }
}
