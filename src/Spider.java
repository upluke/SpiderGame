import java.awt.*;

public class Spider {

    private static final int BODY_SIZE = 40;

    private int x;
    private int y;

    // private char direction;

    public Spider(){}

    public void setX(int x){
        this.x=x;
    }
    public  void setY(int y){
        this.y =y;
    }


    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }


//    public char getDirection(){
//        return this.direction;
//    }

//    public void setDirection(char direction){
//        this.direction= direction;
//    }

    public void move(){

    }
//    public void paintCell( String color){
//          // need to be removed if not using at the end
//    }

    public void draw(Graphics g){
        // TODO: change spider's UI according to the directions
        DataSource ds = DataSource.getInstance();
        char spiderDirection = ds.getSpiderDirection();
        // draw spider's body
        g.setColor(Color.WHITE);
        g.fillOval( x+20, y+20, BODY_SIZE, BODY_SIZE);
        // legs
        g.drawLine(x+15, y+15, x+65, y+65);
        g.drawLine(x+65, y+15, x+15, y+65);

        // draw spider's head with a direction
        if(spiderDirection =='n'){
            //head
            g.fillOval(x+30, y+10, BODY_SIZE/2, BODY_SIZE/2);
            //eyes
            g.setColor(Color.RED);
            g.fillOval(x+34, y+14, BODY_SIZE/6, BODY_SIZE/6);
            g.fillOval(x+40, y+14, BODY_SIZE/6, BODY_SIZE/6);
        }else if(spiderDirection =='e'){
            //head
            g.fillOval(x+50, y+30, BODY_SIZE/2, BODY_SIZE/2);
            //eyes
            g.setColor(Color.RED);
            g.fillOval(x+60, y+34, BODY_SIZE/6, BODY_SIZE/6);
            g.fillOval(x+60, y+40, BODY_SIZE/6, BODY_SIZE/6);
        }else if(spiderDirection =='s'){
            //head
            g.fillOval(x+30, y+50, BODY_SIZE/2, BODY_SIZE/2);
            // eyes
            g.setColor(Color.RED);
            g.fillOval(x+34, y+60, BODY_SIZE/6, BODY_SIZE/6);
            g.fillOval(x+40, y+60, BODY_SIZE/6, BODY_SIZE/6);
        }else{
            //head
            g.fillOval(x+10, y+30, BODY_SIZE/2, BODY_SIZE/2);
            //eyes
            g.setColor(Color.RED);
            g.fillOval(x+14, y+34, BODY_SIZE/6, BODY_SIZE/6);
            g.fillOval(x+14, y+40, BODY_SIZE/6, BODY_SIZE/6);
        }



    }
}
