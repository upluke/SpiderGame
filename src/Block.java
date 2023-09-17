import java.awt.*;

public class Block {
    private Rectangle bounds;
    private Color color;

    private String BlockValue;

    public Block(int x, int y, int w, int h, Color color, String BlockValue){
        // TODO: add BlockValue into constructor
        bounds= new Rectangle(x, y, w, h);
        this.color=color;
        this.BlockValue = BlockValue;
    }

    public int getX(){return bounds.x;}
    public int getY(){return bounds.y;}

    public int getWidth(){return bounds.width;}
    public int getHeight(){return bounds.height;}

    public Color getColor(){return this.color;}

    public String getBlockValue(){return this.BlockValue;}
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
