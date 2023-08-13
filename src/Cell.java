import java.awt.*;
import java.util.HashMap;

public class Cell {
    private boolean hasDiamond;
    private boolean hasSpider;
    private int id;
    private Color diamondColor;
    private char spiderDirection;
    private Spider spider;

    private boolean hasPainted;
    private String paintedColor;
    private int x;
    private int y;

    public Cell (boolean diamond, boolean hasSpider, Color diamondColor, char spiderDirection, boolean hasPainted, String paintedColor, int id){
        this.hasDiamond = diamond;
        this.hasSpider = hasSpider;
        this.diamondColor = diamondColor;
        this.spiderDirection = hasSpider ? spiderDirection : ' ';
        this.hasPainted = hasPainted;
        this.paintedColor = hasPainted? paintedColor: " ";
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
    public Color getDiamondColor(){
        return diamondColor;
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

    public void setHasPainted(Boolean hasPainted){
        this.hasPainted =hasPainted;
    }

    public String getPaintedColor(){
        return this.paintedColor;
    }

    public void setPaintedColor(String color){
        this.paintedColor = color;
    }


    public void draw(Graphics g){
        spider=new Spider();

        g.setColor(Color.WHITE);
        g.drawRect(x, y, 80, 80);
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 79, 79);

        if(hasDiamond){
            g.setColor(diamondColor);
            g.fillRect(x+30, y+30, 20, 20);
        }
        if(hasSpider){
            spider.setX(x);
            spider.setY(y);
            spider.draw(g);
        }
        if(hasPainted){
            if(!paintedColor.equals("none")){
                HashMap<String, Color> colorMap = new HashMap<>(){{
                    put("blue", new Color(0, 0, 255, 128));
                    put("red", new Color(255, 0, 0, 128));
                    put("green", new Color(0, 255, 0, 128));
                }};

                g.setColor(colorMap.get(this.paintedColor));
                g.fillRect(x, y, 79, 79);

            }
        }


    }

}
