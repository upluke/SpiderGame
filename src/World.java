import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


public class World {

    private String level;
    LinkedList<Cell> cells;


    public World (){
        try {
            cells = DataSource.getInstance().getCells();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public void draw(Graphics g){
        int x=50;
        int y=50;
        int rowSize = (int)Math.sqrt(cells.size());
        int rowCount = 0;

        for (Cell c: cells){
            if(rowCount==rowSize){
                y+=80;
                x=50;
                rowCount=0;
            }
            c.setCellPosition(x, y);
            c.draw(g);
            x+=80;
            rowCount+=1;
        }
    }



}
