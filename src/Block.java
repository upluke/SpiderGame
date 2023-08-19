import java.awt.*;

public class Block {
    private Rectangle bounds;
    public Block(int x, int y, int w, int h){
        bounds= new Rectangle(x, y, w, h);
    }

    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);

    }
}
