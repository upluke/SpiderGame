import java.awt.*;

public class Cell {
    private boolean hasDiamond;
    private boolean hasSpider;
    private int id;
    private Color color;
    private char spiderDirection;
    private Spider spider;

    private int x;
    private int y;

    public Cell (boolean diamond, boolean hasSpider, Color color, char spiderDirection, int id){
        this.hasDiamond = diamond;
        this.hasSpider = hasSpider;
        this.color = color;
        this.spiderDirection = hasSpider ? spiderDirection : ' ';
        this.id=id;
    }




    public boolean hasDiamond(){
        return hasDiamond;
    }

    public boolean hasSpider(){
        return hasSpider;
    }

    public void setHasSpider(boolean hasSpider){
        this.hasSpider=hasSpider;
    }
    public Color getColor(){
        return color;
    }

    public int getId(){
        return id;
    }

    public void setCellPosition(int x, int y){
        this.x=x;
        this.y=y;
    }

    public char getSpiderDirection(){
        return this.spiderDirection;
    }

    public void setSpiderDirection(char direction){
        this.spiderDirection = direction;
    }

    public void draw(Graphics g){
        spider=new Spider();

        g.setColor(Color.WHITE);
        g.drawRect(x, y, 80, 80);
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 80, 80);

        if(hasDiamond){
            g.setColor(color);
            g.fillRect(x+30, y+30, 20, 20);
        }
        if(hasSpider){
            spider.setX(x);
            spider.setY(y);
            spider.draw(g);
        }

    }

}
