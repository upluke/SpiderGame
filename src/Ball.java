import java.awt.*;

public class Ball {

    private Rectangle bounds;


    public Ball(int x, int y, int w, int h){
        bounds = new Rectangle(x, y, w, h);

    }

    public int getX(){return bounds.x;}
    public int getY(){return bounds.y;}

    public void move(int x, int y){
        bounds.x = x;
        bounds.y = y;
    }

    public void draw(Graphics g){
        int x= bounds.x, y= bounds.y, h=bounds.height, w= bounds.width;
        g.setColor(Color.orange);
        g.drawOval(x, y, w, h);
        g.fillOval(x, y, w,h );
    }

    public boolean contains(int x, int y){

        return bounds.contains(x, y);
    }


}
