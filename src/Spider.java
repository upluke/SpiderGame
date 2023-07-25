import java.awt.*;

public class Spider {

    private static final int BODY_SIZE = 40;

    private int x;
    private int y;

    private String direction;

    public Spider(){}

    public void setX(int x){
        this.x=x;
    }
    public  void setY(int y){
        this.y =y;
    }

    public void setDirection(String direction){
        this.direction= direction;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }


    public String getDirection(){
        return this.direction;
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval( x+20, y+20, BODY_SIZE, BODY_SIZE);
        g.fillOval(x+30, y+10, BODY_SIZE/2, BODY_SIZE/2);
        g.drawLine(x+15, y+15, x+65, y+65);
        g.drawLine(x+65, y+15, x+15, y+65);
        g.setColor(Color.RED);
        g.fillOval(x+34, y+14, BODY_SIZE/6, BODY_SIZE/6);
        g.fillOval(x+40, y+14, BODY_SIZE/6, BODY_SIZE/6);


    }
}
